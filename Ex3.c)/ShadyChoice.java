class ShadyChoice {
    private volatile boolean getWhite = false;
    private volatile int last = 0;

    public String choose() {
        int me = ThreadId.get();
        last = me;
        if (getWhite)
            return "white";
        getWhite = true;
        if (last == me)
            return "red";
        else
            return "black";
    }

}

/*
Putem observa ca functia choose() este apelata de toate threadurile. Primele threaduri vor ajunge la instructiunea
if getWhite cand getWhite are valoarea false deci vor trece mai departe si vor seta getWhite pe true. Dupa aceea
threadurile vor ajunge la if-ul care verifica daca last este egal cu me. Daca threadurile ajung la acest if in
aceeasi ordine in care au ajuns la if-ul anterior, atunci doar ultimul thread care a trecut de if-ul anterior va
returna "red" deoarece valoarea lui last ramane a aceluia, iar threadurile dinainte de acesta vor returna "black".
In concluzie, un singur thread poate avea valoarea "red", iar daca acest thread este si ultimul thread vom avea restul
de n-1 threaduri cu valoarea "black", deci putem avea maxim un thread cu valoarea "red" si maxim n-1 threaduri cu valoarea
black.
*/