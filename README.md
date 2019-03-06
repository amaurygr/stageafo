# Stage

## Initaliser le projet

### IntelliJ

#### Téléchargement et installation

Télécharger et installer la dernière version d'IntelliJ.

Télécharger et installer la dernière version du JDK 10.

#### Configuration

#### Présentation


### Récupération du projet

#### Git



## Exercices

Cette documentation n'est pas à consulter tout de suite mais pourra vous servir pour la résolution des exercices. 
Documentation de la classe String: https://docs.oracle.com/javase/10/docs/api/java/lang/String.html

Méthodes interessantes de la classse String pour les exercice suivants:

 * length()
 	Renvoie la taille de la chaîne de caractère.
 	Doc: https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#length()

 * charAt(index)
 	Revoie le caractère de la chaîne (String) qui est présent à la position "index".
 	Attention à ne pas dépasser la taille de la chaîne de caractère.
	Doc: https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#charAt(int)

 * toUpperCase()
 	Renvoi une chaîne de caractère (String) dans laquelle tous les caractères minuscules sont converti en majuscules.
 	doc: https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#toUpperCase()




### I - Chiffrement de César

Implémenter le code de Jules César.
Afin d'envoyer des messages cryptés, Jules César a inventé l'algorithme que vous devez implémenter:

Pour plus d'information: http://www.nymphomath.ch/crypto/cesar/index.html


Specification:
 * La message est une chaîne de carctère qui est composé uniquement de lettre et d'epaces.
 * La clef de chiffrement est un entier compris entre 1 et 25.
 * Le message chiffré consiste à remplacer chaque lettre par la "n"ième lettre suivante dans l'alphabet. 
 	Où "n" est la clef de chiffrement.
 * En cas de dépassement de l'alphabet, l'algorithme doit revenir au départ (par exemple la lettre suivant Z est A).
 * Les caractère espace doivent être retranscrit telquel dans le message chiffré.
 * Tout caractère dans les message autre que les lettres et les espaces doivent être ignorés, et ne doivent pas apparaite dans le message chiffré.
 * Les carctères minuscules doivent considérés comme des majuscules.
 * Les message chiffré ne doit contenir que des lettres majuscules et des éspaces.

Example simple:
 * Supposons une chaîne en entrée: ABCD
 * La clé de cryptage : 2
 * Le message chiffré devient donc CDEF.


#### Instructions: 

##### 1. Chiffrement 

Implémenter la méthode de chiffrement `cipher(String clearData, int key)` de la classe `com.halosys.app.stageafo.ciphering.CaesarCiphering` en suvant les spécifications.
Faire en sorte que tous les tests de la classe de test `com.halosys.app.stageafo.ciphering.CaesarCipheringTest` passe au vert.

##### 2. Déchiffrement 

Implémenter la méthode de déchiffrement `decipher(String cipheredData, int key)` qui cous permettra de déchiffré un message chiffré.
Indice: Il est possible, simplement, de coder cette méthode en utilisant la méthode `cipher(..)`.



### II - Chiffrement de Vigenère

Le principe est sensiblement similaire au chiffrement de César, mais cette fois la clef de chiffrement n'est plus un simple nombre mais une chaîne de caractère. Cet algorithme est cependant plus résistant à la crytanalyse.

Pour plus d'information: 
Chiffrement de Vigenère: http://www.nymphomath.ch/crypto/vigenere/index.html
Analyse de fréquence: http://www.nymphomath.ch/crypto/stat/index.html

Il n'est plus question, dans le chiffrement de Vigère, d'appliquer pour chaque lettre du message le même décalage. Cette fois le décalage sera changeant pour chaque lettre de la clef et fonction de la position de la lettre dans l'alphabet (A: 1, B, 2, C: 3, etc).

Note: L'indice d'une lettre corresond à la position de la-dite lettre dans l'alphabet

L'alogorithme fonctionne de la manière suivante:
Prenons l'example d'un message en clair: ABCD et d'une clef de chiffrement: CLEF.
Pour obtenir le message chiffré nous allons donc, pour le première lettre, décaller 'A' de l'indice de 'C', puis 'B' de l'indice de 'L', puis 'C' de l'indice de 'E' et enfin 'D' de l'indice de 'F'.

Le tableau suivant illustre cette example:

| - | - | - | - | - |
| Messsage | A | B | C | D |
| Indice Message |1 | 2 | 3 | 4 |
| Clef | C | L | E | F |
| Indice clef | 4 | 12 | 5 | 6 |
| Indice chiffré (somme de l'indice du message et de l'indice de la clef) | 5 | 14 | 8 | 10 | 
| Message chiffré | E | N | H | J |


Cette example illustre un cas où la clef de chiffrement est de même taille que le message à chiffré, mais ce n'est pas nécésairement le cas.

Dans le cas où une clef est plus longue que le message il faut simplement ne pas tenir compte des caractères excédentaire de la clef.

Example:
 - Messaage: MESSAGE
 - Clef: UNECLEFBIENLONGUE

|Messsage|M|E|S|S|A|G|E|
|Clef|U|N|E|C|L|E|F|
|Message chiffré|H|S|X|V|M|N|K|


Et il existe aussi le cas où clef de chiffrement est plus courte que le message aà chhiffré. Dans ce cas il faut répéter la clef autant de fois que nécessaire afin d'arriver jusqu'à la dernière lettre du message. S'il rest des caractère excédentaire il devront être ignoré comme vu dans l'example précédent.


Example:
 - Messaage: MESSAGELONG
 - Clef: CLEF

|Messsage|M|E|S|S|A|G|E|L|O|N|G|
|Clef|C|L|E|F|C|L|E|F|C|L|E|
|Message chiffré|P|Q|X|Y|D|S|J|R|R|Z|L|


Specification:
 * La message est une chaîne de carctère qui est composé uniquement de lettre et d'epaces.
 * La clef de chiffrement est un entier compris entre 1 et 25.
 * Le massage chiffré consiste à remplacer chaque lettre par la "n"ième lettre suivante dans l'alphabet. 
 	Où "n" correspond à l'indice de la lettre correspondante de la clef.
 * En cas de dépassement de l'alphabet, l'algorithme doit revenir au départ (par exemple la lettre suivant Z est A).
 * Les caractère espace doivent être retranscrit telquel dans le message chiffré.
 * Tout caractère dans les message autre que les lettres et les espaces doivent être ignorés, et ne doivent pas apparaite dans le message chiffré.
 * Les carctères minuscules doivent considérés comme des majuscules.
 * Les message chiffré ne doit contenir que des lettres majuscules et des éspaces.
 * Si la clef est plus longue que le message 
 * Si la clef est courte que la taille du message, cette dernière sera répétée jusqu'a atteidre la taille du-dit message.

#### Instructions: 

##### 1. Chiffrement 

Implémenter la méthode de chiffrement `cipher(String clearData, String key)` de la classe `com.halosys.app.stageafo.ciphering.CaesarCiphering` en suvant les spécifications.
Faire en sorte que tous les tests de la classe de test `com.halosys.app.stageafo.ciphering.VigenereCipheringTest` passe au vert.

##### 2. Déchiffrement

Implémenter la méthode de déchiffrement `decipher(String cipheredData, String key)` qui cous permettra de déchiffré un message chiffré.