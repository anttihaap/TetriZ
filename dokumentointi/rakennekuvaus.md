# Rakennekuvaus

## Pelielementit:

**Nelio:** Nelio pit�� sis�ll��n kordinaatit (X ja Y) ja kuvan. Nelioita voi siirtaa k�ytt�m�ll� sen asetaX() ja asetaY()
metodeja. Nelio my�s palauttaa kuvan palautaKuva()-metodilla.

**Pala:** Pala on kokonaisuus, joka sis�lt�� 4 neli�t�. Palalla on my�s luokka TetrisPalatyyppi, jonka avulla luodaan
palan nelioiden asetelma ja kuva. TetrisPalatyyppi voidaan p��tt�� palalle konstruktorissa tai se voidaan arpoa Palalle. Palan neli�t
luodaan TetrisPalatyypin mukaisesti, mutta niit� siirret��n palan aloituskordinaattien mukaan.
Palaa liikuttaessa tai k��nnett�ess� kaikki sen neli�t
siirtyv�t kent�ss� kyseisen sunnan mukaisesti. 

**TetrisPalatyyppit:** TetrisPalatyypit on luokka pit�� sis�ll��n m��ritelm�t Pala-luokalle (Tetrispalalle).
TetrisPalatyyppi pit�� sis�ll��n m��ritelm�t neli�iden asetelmalle ja neli�iden kuville. Tetrispalatyyppej� on
7 kuten perinteisess� tetriksess�kin.

**Kentta:** Kentta pit�� sis�ll��n kordinaatiston, joka koostuu kuvista. Kentt��n voidaan liitt�� paloja.

## Logiikka

**Peli:** Peli pit�� sis�ll��n kaikki pelin toiminnallisuuden kannalta t�rke�t asiat: nykyisen liikutettavan palan
, seuraavan palan, palojen liikuttamisen ja pisteytyksen. Peli palauttaa
my�s pelitilannetta kordinaatiston muodossa. 

Luokka tuntee Palalogiikan, joka p��tt�� palojen liikutuksen, ja Kentt�logiikan, joka hoitaa selvitt�� t�ydet rivit ja 
tuhoaa t�ydet rivit.

Peli-luokka tuntee PelinTilasto luokan, joka hoitaa pisteytyksen.

**Palalogiikka:** Luokka p��tt�� voiko tietty� palaa liikuttaa kent�ss� (oikealle, vasemmalle, alas) tai k��nt�� kent�ss�.
Luokka my�s tarkistaa, ett� onko pala k��nt�ess� kent�n kordinaattien sis�ll�.

**Kenttalogiikka:** Luokka palauttaa t�ydet rivit ja poistaa rivej� kent�st�.

**PelinTilasto:** Pit�� sis�ll��n tietoa pelin kulusta: pisteet, luotujen palojen m��r� ja tuhottujen rivien m��r�n. Luokka pisteytt�� 
riippuen pelin vaikeustasosta ja tuhottujen rivien m��r�st� (per. pisteytys kerta).

**PelinAsetukset:** Luokka sis�lt�� asetukset, eli pelin ominaisuudet: vaikeustaso, piirret��nk� varjopala ja piirret�nk� seuraava pala.

## Kayttoliittyma

**Paaikkuna:** K�ytt�liittym�n runko, joka hallitsee k�ytt�liittym�n paneeleita (valikkoa ja pelipaneelia). P��ikkuna tuntee kaikki Valikko-luokkaa
k�ytt�v�t valikot ja Pelipaneelin.

**Valikko:** Luokka pit�� sis�ll��n ominaisuudet, joita tarvitaan nuoli n�pp�imill� selattavaan valikkoon.

**P��valikko:** Luokka on p��valikko pelille. 

**AsetuksetValikko:** Valikko josta k�ytt�j� voi vaihtaa pelin asetuksia.

**Pelipaneeli:** Sis�lt�� pelin p��s�ijeen ja piirt�� peli�.



## Tyokalut

**Kuvanlataaja:** Kuvanlataajalla ladataan kuvia.