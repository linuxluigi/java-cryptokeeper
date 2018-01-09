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

    Transaktion: {[\underline{TransaktionId : integer}, Anazhl : float, Zeitstempel : Zeitstempel, Wechselkurs : float, Transaktions Art : string, CoinId : integer, InvestorId : integer, WalletId : integer]}

    Börse: {[\underline{BoersenId : integer}, Name : string, URL : string]}

    Wallet: {[\underline{WalletId : integer}, Addresse : string, CoinId : integer]}

    Krypto Coin: {[\underline{CoinId : integer}, Name : string, Kürzel : string, Zeitstempel : integer, AlgorithmusId : integer, PruefVerfahrenId : integer]}

    Algorithmus: {[\underline{AlgorithmusId : integer}, Name : string]}

    Prüf Verfahren: {[\underline{PruefVerfahrenId : integer}, Name : string]}

Tabellen Form
-------------

=====  =====
Inputs
------------
  A      B
=====  =====
False  False
True   False
False  True
True   True
=====  =====