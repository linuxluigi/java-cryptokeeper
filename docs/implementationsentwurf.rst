Implementationsentwurf
======================

Initial-Entwurf
---------------

.. raw:: latex

    Kontakt Person: {[\underline{KontaktId : integer}, Vornamen : string, Nachnamen : string, Position : string, Email : string, Telefonummer : string]}

    Investor: {[\underline{InvestorId : integer}, Firmenname : string, Straße : string, Stadt : string, Postleitzahl : string]}

    Transaktion: {[\underline{TransaktionId : integer}, Anazhl : float, Zeitstempel : Zeitstempel, Wechselkurs : float, Transaktions Art : string]}

    Börse: {[\underline{BoersenId : integer}, Name : string, URL : string]}

    Wallet: {[\underline{WalletId : integer}, Addresse : string]}

    Krypto Coin: {[\underline{CoinId : integer}, Name : string, Kürzel : string, Zeitstempel : integer]}

    Algorithmus: {[\underline{AlgorithmusId : integer}, Name : string]}

    Prüf Verfahren: {[\underline{PruefVerfahrenId : integer}, Name : string]}

    Ansprechpartner: {[\underline{InvestorId : integer}, \underline{KontaktId : integer}]}

    gehört: {[\underline{InvestorId : integer}, \underline{TransaktionId : integer}]}

    handelt an: {[\underline{BoersenId : integer}, \underline{TransaktionId : integer}]}

    sichert coins: {[\underline{WalletId : integer}, \underline{TransaktionId : integer}]}

    wird gehandelt: {[\underline{CoinId : integer}, \underline{TransaktionId : integer}]}

    berechnet mit: {[\underline{CoinId : integer}, \underline{AlgorithmusId : integer}]}

    geprüft mit: {[\underline{CoinId : integer}, \underline{PruefVerfahrenId : integer}]}

    gesichert: {[\underline{CoinId : integer}, \underline{WalletId : integer}]}

Verfeinerung durch Zusammenfassung
----------------------------------

.. raw:: latex

    Kontakt Person: {[\underline{KontaktId : integer}, Vornamen : string, Nachnamen : string, Position : string, Email : string, Telefonummer : string, ansprechpartnerVon : integer]}

    Investor: {[\underline{InvestorId : integer}, Firmenname : string, Straße : string, Stadt : string, Postleitzahl : string]}

    Transaktion: {[\underline{TransaktionId : integer}, Anazhl : float, Zeitstempel : Zeitstempel, Wechselkurs : float, Transaktions Art : string, CoinId : integer, InvestorId : integer, WalletId : integer, InvestorId : integer]}

    Börse: {[\underline{BoersenId : integer}, Name : string, URL : string]}

    Wallet: {[\underline{WalletId : integer}, Addresse : string, CoinId : integer]}

    Krypto Coin: {[\underline{CoinId : integer}, Name : string, Kürzel : string, Zeitstempel : integer, AlgorithmusId : integer, PruefVerfahrenId : integer]}

    Algorithmus: {[\underline{AlgorithmusId : integer}, Name : string]}

    Prüf Verfahren: {[\underline{PruefVerfahrenId : integer}, Name : string]}

Tabellen Form
-------------

============================  ============================  ============================  ============================  ============================
investor
----------------------------------------------------------------------------------------------------------------------------------------------------
investor_id                   firmenname                    straße                        stadt                         postleitzahl
============================  ============================  ============================  ============================  ============================
1                             CoinHolder GmbH               Mustersteg 27                 Groß Kiez                     13147
2                             Fruits & Co Kg                Bananenlauf 15                Ackerland                     13133
3                             Trading AG                    Kuhdamm                       Berlin                        10966
4                             Getränke Handel Hans          Buschkrug Alle 12             Groß Kiez                     13147
============================  ============================  ============================  ============================  ============================

============================  ============================  ============================  ============================  ============================  ============================  ============================
kontakt_person
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
kontakt_id                    vornamen                      nachnamen                     position                      email                         telefonnummer                 ansprechpartner_von
============================  ============================  ============================  ============================  ============================  ============================  ============================
0                             Lisa                          Schmidt                       Assistent                     lisa.schmidt@coin.de          123456789                     1
1                             Linda                         Krans                         Geschäftsführer               krans@linda.de                234567890                     2
2                             Harald                        Hard                          Inhaber                       hart@harald.com               345678901                     3
3                             Frido                         Froh                          Assistent                     froh@hans-getranke.de         456789012                     4
============================  ============================  ============================  ============================  ============================  ============================  ============================

============================  ============================
algorithmus
----------------------------------------------------------
algorithmus_id                name
============================  ============================
1                             SHA256
2                             Scrypt
3                             CryptoNight
4                             X11
============================  ============================

============================  ============================
pruef_verfahren
----------------------------------------------------------
pruef_verfahren_id            name
============================  ============================
1                             PoW
2                             PoS
3                             PoW/PoS
============================  ============================

============================  ============================  ============================  ============================  ============================
krypto_coin
----------------------------------------------------------------------------------------------------------------------------------------------------
coin_id                       name                          kuerzel                       berechnet_mit                 geprueft_mit
============================  ============================  ============================  ============================  ============================
1                             Bitcoin                       BTC                           1                             1
2                             Litecoin                      LTC                           2                             1
3                             Monero                        XMR                           3                             1
4                             CRAIG                         CRAIG                         4                             2
============================  ============================  ============================  ============================  ============================

============================  ============================  ============================
boerse
----------------------------------------------------------------------------------------
boerse_id                     name                          url
============================  ============================  ============================
1                             MtGox                         https://mtgox.com
2                             Bitstamp                      https://bitstamp.net
3                             Kraken                        https://kraken.com
4                             Localbitcoins                 https://localbitcoins.com
============================  ============================  ============================

============================  ===========================================  ==============
wallet
-----------------------------------------------------------------------------------------
wallet_id                     addresse                                     gesicherter
============================  ===========================================  ==============
1                             itdw27cN3mprpZ3PTAUs4FKuEg7wAnh6URw8a14PCBk  1
2                             N5u2a5u3szELc9SiEseVmjKiHMZKm5imcRQlQQZfLhe  2
3                             uibRalcAD1Af5nPezQBfQKF24F48h68Vqlixn6WpmT1  3
4                             tf89JYlxByyCklLdv96irL4QF7ibdyYGK62OFeYqIy2  4
5                             ddddJYlxByydsfggfddfghCklLdv96irL4QF7isdIy2  1
============================  ===========================================  ==============

============================  ============================  ============================  ============================  ============================  ============================  ============================  ============================
transaktion
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
transaction_id                anzahl                        zeitstempel                   wechselkurs                   transaktions_art              gehandelt                     gesichert_in                  gehoert
============================  ============================  ============================  ============================  ============================  ============================  ============================  ============================
1                             12.5                          2018-01-08 20:09:38.830624    1.99                          buy                           1                             1                             1
2                             5                             2018-01-08 20:09:38.833055    0.001                         buy                           2                             2                             2
3                             19.99                         2018-01-08 20:09:38.835596    10242.001                     sell                          3                             3                             3
4                             0.0012                        2018-01-08 20:09:38.837327    23.53                         buy                           4                             4                             3
============================  ============================  ============================  ============================  ============================  ============================  ============================  ============================
