# Rakennekuvaus

## Pelielementit:

*Nelio:* Nelio pit�� sis�ll��n kordinaatit (X ja Y) ja kuvan.

*Pala:* Pala on kokonaisuus, joka sis�lt�� 4 neli�t�. Palalla on my�s luokka TetrisPalatyyppi, joka m��rittelee
Pala-luokan neli�it�. TetrisPalatyyppi voidaan p��tt�� palalle konstruktorissa tai arpoa Palalle. Palan neli�t
luodaan TetrisPalatyypin mukaisesti, mutta niit� siirret��n palan aloituskordinaattien mukaan.
Palaa liikuttaessa tai k��nnett�ess� kaikki sen neli�t
siirtyv�t kent�ss� kyseisen sunnan mukaisesti. 

*TetrisPalatyyppit:* TetrisPalatyypit on luokka pit�� sis�ll��n m��ritelm�t Pala-luokalle (Tetrispalalle).
TetrisPalatyyppi pit�� sis�ll��n m��ritelm�t neli�iden asetelmalle ja neli�iden kuville. Tetrispalatyyppej� on
7 kuten perinteisess� tetriksess�kin.

*Kentta:* Kentta pit�� sis�ll��n kordinaatiston, joka koostuu kuvista. Kentt��n voidaan liitt�� paloja.

## Logiikka

