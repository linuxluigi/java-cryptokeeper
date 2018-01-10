SQL Befehle
===========

Befehl B (Join & Kathesisches Produkt)
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Welche Investoren haben welche Transaktionen getätigt?

.. code-block:: sql

   SELECT transaction_id, firmenname FROM transaktion JOIN investor i ON transaktion.gehoert = i.investor_id;

Welche Investoren haben mindestens eine Transaktion getätigt?

.. code-block:: sql

   SELECT investor_id from investor INTERSECT (SELECT gehoert from transaktion);

Befehl C (in or not exists)
^^^^^^^^^^^^^^^^^^^^^^^^^^^

Welche Wallet wurde nicht verwendet?

.. code-block:: sql

   SELECT * from wallet WHERE NOT EXISTS(SELECT * FROM transaktion WHERE gesichert_in=wallet.wallet_id);

Befehl D (Group)
^^^^^^^^^^^^^^^^

Wie oft kommen die jeweiligen Postleitzahlen in Investor vor?

.. code-block:: sql

   SELECT count(investor_id), postleitzahl FROM investor GROUP BY postleitzahl;

Wie oft wird welche Wallet Adresse in Transaktion verwendet, die mindestens einmal vorkommt?

.. code-block:: sql

    SELECT count(wallet_id), addresse FROM wallet WHERE EXISTS(SELECT * FROM transaktion WHERE gesichert_in=wallet.wallet_id) GROUP BY addresse;


Befehl E (Having)
^^^^^^^^^^^^^^^^^

Welche Krypto Coins wurde im durchschnitt Wechselkurs mit weniger als 2 Euro gehandelt?

.. code-block:: sql

   SELECT gehandelt from transaktion GROUP BY gehandelt HAVING avg(wechselkurs) < 2;