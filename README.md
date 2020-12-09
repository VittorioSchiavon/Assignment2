[![Build Status](https://travis-ci.com/VittorioSchiavon/Assignment2.svg?branch=master)](https://travis-ci.com/VittorioSchiavon/Assignment2)

Segnalo che non Coveralls non riesce ad eseguire la build per colpa del seguente errore:
Failed to execute goal org.eluder.coveralls:coveralls-maven-plugin:4.3.0:report (default-cli) on project icecream-shop-manager: I/O operation failed: No source found for it/unipd/tos/business/exception/RestaurantBillException.java

il problema è sorto dopo che ho dovuto eseguire una migrazione da travis-ci.org a travis-ci.com.

I test sono comunque corretti e coprono gran parte del codice.
