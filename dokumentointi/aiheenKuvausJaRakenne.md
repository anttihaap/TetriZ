#TetriZ

Aiheena totetuttaa hävytön klooni tetris-pelistä.

**Pelin toiminnallisuus:**

Pala liikkuu alas kentässä automaattisesti tietyn aikavälein riippuen vaikeustasosta. Korkeampi vaikeustaso liikuttaa palaa nopeammin tehden pelistä vaikeamman.
 
Varjopala, eli alin kohta johon liikutettava pala liikkuu, seuraava pala ja pisteytys näkyy pelipaneelin oikealla puolella.

Käyttäjä liikuttaa palaa nuolinäppäimiä käyttäen:

* Palan liikkuminen:
  * Tetrispalaa ohjataan sivuttaissuunnassa nuolinäppäimillä.
  * Palaa voi kääntää 90-astetta oikealle painamalla nuolinäppäintä ylös.
  * Alas nuolinäppäin nopeuttaa palan liikkumista alaspäin. 
  * SPACE-näppäimellä pala siirtyy heti niin alas kuin mahdollista.
  * Varjopala näyttää mihin pala siirtyy, jos SPACE-nappainta painaa.



**Kentan toiminnallisuus:**

Peli tarkistaa onko rivit täynnä uuden palan luonnin yhteydessä. Jos rivit ovat täysiä, ne häviävät kentästä ja pelaaja saa tästä pisteitä.

**Pelitilastot:** 
* Jokainen peli pisteytetään.
* Vaikeustaso vaikuttaa pisteytykseen: mitä korkeampi vaikeustaso, sitä enemmän pisteitä voi saada rivien tuohamisesta.
* Mitä enemmän pelaaja poistaa rivejä kerralla, sitä enemmän siitä saa pisteitä.
* Palan liittäminen kenttään lisää pistettä 3:lla.

**Käyttöliittymä:**
Käyttöliittymää selataan nuoli näppäimillä ylös ja alas. Käyttäjä voi aloittaa uuden pelin, siirtyä asetukset valikkoon tai poistua ohjelmasta päävalikon kautta. Tämän hetkinen valinta näkyy keltaisena. ENTER-näppäimellä siirrytään valikosta toiseen tai muutetaan asetuksen arvoa. Pelaaja voi asetuksista muuttaa pelin toiminnallisuutta. 
* Asetukset-valikko:
  * Käyttäjä muuttaa pelin asetuksia:
  * Piirretäänkö varjopala.
  * Piiretäänkö seuraava pala.
  * Vaikeustason valinta.

**Laajennusehdotuksia:**

Laajennusehdotuksia: ideat joita en ehtinyt toteuttaa.

* Pisteytys käyttäen käyttäjän antamaa nimeä "Highscore" taulukkona.
* Tetrisvariaatioita:
  * Peli luo mahdollisimman huonoja paloja riippuen pelitilanteesta. "Pelaa jumalaa vastaan"
  * Kenttä kääntyilee 180 astetta riippeun tilanteesta.
  * Palat tuhoutuvat kentästä värin mukaan.


