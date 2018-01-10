--investor

INSERT INTO investor (investor_id, firmenname, straße, stadt, postleitzahl)
VALUES (1, 'CoinHolder GmbH', 'Mustersteg 27', 'Groß Kiez', '13147');

INSERT INTO investor (investor_id, firmenname, straße, stadt, postleitzahl)
VALUES (2, 'Fruits & Co Kg', 'Bananenlauf 15', 'Ackerland', '13133');

INSERT INTO investor (investor_id, firmenname, straße, stadt, postleitzahl)
VALUES (3, 'Trading AG', 'Kuhdamm', 'Berlin', '10966');

INSERT INTO investor (investor_id, firmenname, straße, stadt, postleitzahl)
VALUES (4, 'Getränke Handel Hans', 'Buschkrug Alle 12', 'Groß Kiez', '13147');

--kontakt_person

INSERT INTO kontakt_person (kontakt_id, vornamen, nachnamen, position, email, telefonnummer, ansprechpartner_von)
VALUES (0, 'Lisa', 'Schmidt', 'Assistent', 'lisa.schmidt@coin.de', '123456789', 1);

INSERT INTO kontakt_person (kontakt_id, vornamen, nachnamen, position, email, telefonnummer, ansprechpartner_von)
VALUES (1, 'Linda', 'Krans', 'Geschäftsführer', 'krans@linda.de', '234567890', 2);

INSERT INTO kontakt_person (kontakt_id, vornamen, nachnamen, position, email, telefonnummer, ansprechpartner_von)
VALUES (2, 'Harald', 'Hard', 'Inhaber', 'hart@harald.com', '345678901', 3);

INSERT INTO kontakt_person (kontakt_id, vornamen, nachnamen, position, email, telefonnummer, ansprechpartner_von)
VALUES (3, 'Frido', 'Froh', 'Assistent', 'froh@hans-getranke.de', '456789012', 4);

--boerse

INSERT INTO boerse (boerse_id, name, url)
VALUES (1, 'MtGox', 'https://mtgox.com');

INSERT INTO boerse (boerse_id, name, url)
VALUES (2, 'Bitstamp', 'https://bitstamp.net');

INSERT INTO boerse (boerse_id, name, url)
VALUES (3, 'Kraken', 'https://kraken.com');

INSERT INTO boerse (boerse_id, name, url)
VALUES (4, 'Localbitcoins', 'https://localbitcoins.com');

--algorithmus

INSERT INTO algorithmus (algorithmus_id, name)
VALUES (1, 'SHA256');

INSERT INTO algorithmus (algorithmus_id, name)
VALUES (2, 'Scrypt');

INSERT INTO algorithmus (algorithmus_id, name)
VALUES (3, 'CryptoNight');

INSERT INTO algorithmus (algorithmus_id, name)
VALUES (4, 'X11');

--pruef_verfahren

INSERT INTO pruef_verfahren (pruef_verfahren_id, name)
VALUES (1, 'PoW');

INSERT INTO pruef_verfahren (pruef_verfahren_id, name)
VALUES (2, 'PoS');

INSERT INTO pruef_verfahren (pruef_verfahren_id, name)
VALUES (3, 'PoW/PoS');

--krypto_coin

INSERT INTO krypto_coin (coin_id, name, kuerzel, berechnet_mit, geprueft_mit)
VALUES (1, 'Bitcoin', 'BTC', 1, 1);

INSERT INTO krypto_coin (coin_id, name, kuerzel, berechnet_mit, geprueft_mit)
VALUES (2, 'Litecoin', 'LTC', 2, 1);

INSERT INTO krypto_coin (coin_id, name, kuerzel, berechnet_mit, geprueft_mit)
VALUES (3, 'Monero', 'XMR', 3, 1);

INSERT INTO krypto_coin (coin_id, name, kuerzel, berechnet_mit, geprueft_mit)
VALUES (4, 'CRAIG', 'CRAIG', 4, 2);

--wallet

INSERT INTO wallet (wallet_id, addresse, gesicherter)
VALUES (1, 'itdw27cN3mprpZ3PTAUs4FKuEg7wAnh6URw8a14PCBk', 1);

INSERT INTO wallet (wallet_id, addresse, gesicherter)
VALUES (2, 'N5u2a5u3szELc9SiEseVmjKiHMZKm5imcRQlQQZfLhe', 2);

INSERT INTO wallet (wallet_id, addresse, gesicherter)
VALUES (3, 'uibRalcAD1Af5nPezQBfQKF24F48h68Vqlixn6WpmT1', 3);

INSERT INTO wallet (wallet_id, addresse, gesicherter)
VALUES (4, 'tf89JYlxByyCklLdv96irL4QF7ibdyYGK62OFeYqIy2', 4);

INSERT INTO wallet (wallet_id, addresse, gesicherter)
VALUES (5, 'ddddJYlxByydsfggfddfghCklLdv96irL4QF7isdIy2', 1);

--transaktion

INSERT INTO transaktion (transaction_id, anzahl, wechselkurs, transaktions_art, gehandelt, gesichert_in, gehoert)
VALUES (1, 12.5, 1.99, 'buy', 1, 1, 1);

INSERT INTO transaktion (transaction_id, anzahl, wechselkurs, transaktions_art, gehandelt, gesichert_in, gehoert)
VALUES (2, 5, 0.001, 'buy', 2, 2, 2);

INSERT INTO transaktion (transaction_id, anzahl, wechselkurs, transaktions_art, gehandelt, gesichert_in, gehoert)
VALUES (3, 19.99, 10242.001, 'sell', 3, 3, 3);

INSERT INTO transaktion (transaction_id, anzahl, wechselkurs, transaktions_art, gehandelt, gesichert_in, gehoert)
VALUES (4, 0.0012, 23.53, 'buy', 4, 4, 3);
