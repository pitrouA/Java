

12/05 -- IA Directive + Alexis/Master
- IA directive fonctionne
- Merge principalement du moteur (explosion, restructuration de la m�thode tombe, IA directive)
- Rajout du mode DEBUG

------------------------------------------------------------------------------



28/04/2017 -- Version du jeu suffisante

- M�caniques de Jeu :
  Les ennemis tuent, se d�placent, les rochers tombent, les diamants sont r�cup�rables, murs magiques op�rationnels, on peut mourrir ou gagner et acc�der au niveau sup�rieur, etc.

  --> Il manque : les explosions, quelques d�tails pour les ennemis, ...

- Interface Graphique Op�rationnelle, compteur de points, de diamants, ...

- IA :
1) Random - OK
2) G�n�tique - En cours
3) Directive - En cours
4) Directive Evolu�e - Nom commenc�e
5) Parfaite - Non commenc�e




------------------------------------------------------------------------------






Merge du 18/04 -- Version en vigueur / Version d'Adrien

Ecrit/Lu par : Quentin
Non lu : Alexis, Adrien, (Nicolas ?)

Merge : 1

- Ajout des options et de MainTest_v2 :
>> Pour faire fonctionner MainTest_v2, il faut penser � rajouter des options !
>> Clic Droit sur Maintest_v2 -> Run As.. --> Run Configurations --> Modifier les arguments
-joue pour jouer
-name pour les noms
...

- Ajout du sujet en .pdf, du dossier ressources d'Adrien

Merge : 2
- Ajout de ce petit fichier pour faciliter la communication/les explications lors de commit, push..
Abusez-en si il y a quelque chose d'important � dire.

- MAJ du Menu d'Adrien (+ Color� ; + Compteurs), ajout de Sortie2.png

Merge : 3
- D�placement des ennemis impl�ment�s : Fonctionne sans probl�me MAIS
1) MoteurJeu.espace (les cases vides) --> est maintenant public et static
2) Deplacable.deplacer() --> Deplacable.deplacer(Entite[][] carte)
Cela pourrait nous poser quelques probl�mes, faites y attention

Merge : 4 
- Impl�mentation de la derni�re version du package affichage

>>La version de chargerImage() pour le .jar ne fonctionne pas, j'ai repris l'ancienne en prenant le soin de garder celle qui ne marche pas bien

>> D�couverte d'un bug : Certains diamants ne sont pas ramass�s du premier coup
--> Probl�me de HashSet ?
--> Probl�me avec public static espace ?


----- Fin du Merge