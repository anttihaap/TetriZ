# Rakennekuvaus

## Pelielementit:

*Nelio:* Nelio pitää sisällään kordinaatit (X ja Y) ja kuvan.

*Pala:* Pala on kokonaisuus, joka sisältää 4 neliötä. Palalla on myös luokka TetrisPalatyyppi, joka määrittelee
Pala-luokan neliöitä. TetrisPalatyyppi voidaan päättää palalle konstruktorissa tai arpoa Palalle. Palan neliöt
luodaan TetrisPalatyypin mukaisesti, mutta niitä siirretään palan aloituskordinaattien mukaan.
Palaa liikuttaessa tai käännettäessä kaikki sen neliöt
siirtyvät kentässä kyseisen sunnan mukaisesti. 

*TetrisPalatyyppit:* TetrisPalatyypit on luokka pitää sisällään määritelmät Pala-luokalle (Tetrispalalle).
TetrisPalatyyppi pitää sisällään määritelmät neliöiden asetelmalle ja neliöiden kuville. Tetrispalatyyppejä on
7 kuten perinteisessä tetriksessäkin.

*Kentta:* Kentta pitää sisällään kordinaatiston, joka koostuu kuvista. Kenttään voidaan liittää paloja.

## Logiikka

