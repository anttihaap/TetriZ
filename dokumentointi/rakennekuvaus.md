# Rakennekuvaus

## Pelielementit:

**Nelio:** Nelio pitää sisällään kordinaatit (X ja Y) ja kuvan. Nelioita voi siirtaa käyttämällä sen asetaX() ja asetaY()
metodeja. Nelio myös palauttaa kuvan palautaKuva()-metodilla.

**Pala:** Pala on kokonaisuus, joka sisältää 4 neliötä. Palalla on myös luokka TetrisPalatyyppi, jonka avulla luodaan
palan nelioiden asetelma ja kuva. TetrisPalatyyppi voidaan päättää palalle konstruktorissa tai se voidaan arpoa Palalle. Palan neliöt
luodaan TetrisPalatyypin mukaisesti, mutta niitä siirretään palan aloituskordinaattien mukaan.
Palaa liikuttaessa tai käännettäessä kaikki sen neliöt
siirtyvät kentässä kyseisen sunnan mukaisesti. 

**TetrisPalatyyppit:** TetrisPalatyypit on luokka pitää sisällään määritelmät Pala-luokalle (Tetrispalalle).
TetrisPalatyyppi pitää sisällään määritelmät neliöiden asetelmalle ja neliöiden kuville. Tetrispalatyyppejä on
7 kuten perinteisessä tetriksessäkin.

**Kentta:** Kentta pitää sisällään kordinaatiston, joka koostuu kuvista. Kenttään voidaan liittää paloja.

## Logiikka

**Peli:** Peli pitää sisällään kaikki pelin toiminnallisuuden kannalta tärkeät asiat: nykyisen liikutettavan palan
, seuraavan palan, palojen liikuttamisen ja pisteytyksen. Peli palauttaa
myös pelitilannetta kordinaatiston muodossa. 

Luokka tuntee Palalogiikan, joka päättää palojen liikutuksen, ja Kenttälogiikan, joka hoitaa selvittää täydet rivit ja 
tuhoaa täydet rivit.

Peli-luokka tuntee PelinTilasto luokan, joka hoitaa pisteytyksen.

**Palalogiikka:** Luokka päättää voiko tiettyä palaa liikuttaa kentässä (oikealle, vasemmalle, alas) tai kääntää kentässä.
Luokka myös tarkistaa, että onko pala kääntäessä kentän kordinaattien sisällä.

**Kenttalogiikka:** Luokka palauttaa täydet rivit ja poistaa rivejä kentästä.

## Tyokalut

**Kuvanlataaja:** Kuvanlataajalla ladataan kuvia.