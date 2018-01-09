--drop tables if exists

DROP TABLE kontakt_person;
DROP TABLE investor;
DROP TABLE transaktion;
DROP TABLE boerse;
DROP TABLE wallet;
DROP TABLE krypto_coin;
DROP TABLE algorithmus;
DROP TABLE pruef_verfahren;

--create new tables

CREATE TABLE investor
(
  investor_id  INTEGER PRIMARY KEY,
  firmenname   VARCHAR(30),
  straße       VARCHAR(30),
  stadt        VARCHAR(30),
  postleitzahl VARCHAR(30)
);

CREATE TABLE kontakt_person
(
  kontakt_id          INTEGER PRIMARY KEY,
  vornamen            VARCHAR(30)        NOT NULL,
  nachnamen           VARCHAR(30)        NOT NULL,
  position            CHAR(15) CHECK (position IN ('Inhaber', 'Geschäftsführer', 'Assistent')),
  email               VARCHAR(50) UNIQUE,
  telefonnummer       VARCHAR(20) UNIQUE NOT NULL,
  ansprechpartner_von INTEGER REFERENCES investor ON DELETE CASCADE
);

CREATE TABLE algorithmus
(
  algorithmus_id INTEGER PRIMARY KEY,
  name           VARCHAR(30) NOT NULL
);

CREATE TABLE pruef_verfahren
(
  pruef_verfahren_id INTEGER PRIMARY KEY,
  name               VARCHAR(30) NOT NULL
);

CREATE TABLE krypto_coin
(
  coin_id       INTEGER PRIMARY KEY,
  name          VARCHAR(30) NOT NULL,
  kuerzel       VARCHAR(8)  NOT NULL,
  berechnet_mit INTEGER REFERENCES algorithmus,
  geprueft_mit  INTEGER REFERENCES pruef_verfahren
);

CREATE TABLE boerse
(
  boerse_id INTEGER PRIMARY KEY,
  name      VARCHAR(30) NOT NULL,
  url       VARCHAR(30) NOT NULL
);

CREATE TABLE wallet
(
  wallet_id   INTEGER PRIMARY KEY,
  addresse    VARCHAR(100) NOT NULL,
  gesicherter INTEGER REFERENCES krypto_coin
);

CREATE TABLE transaktion
(
  transaction_id   SERIAL PRIMARY KEY,
  anzahl           FLOAT NOT NULL,
  zeitstempel      TIMESTAMP DEFAULT current_timestamp, --auto fill with current unix time
  wechselkurs      FLOAT NOT NULL,
  transaktions_art CHAR(4) CHECK (transaktions_art IN ('buy', 'sell')),
  gehandelt        INTEGER REFERENCES krypto_coin,
  gesichert_in      INTEGER REFERENCES wallet
);
