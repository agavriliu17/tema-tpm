# Exercitiul 2

De ce in mod obisnuit in utilizarea unui lock se prefera ca apelul lock() sa fie executat inainte de blocul try, si nu in cadrul acestuia (prima varianta de mai jos si nu a doua)? Argumentati.

> lock inainte de try:

```java
someLock.lock();
try {
   .....
}
finally {
   someLock.unlock();
}
```

> lock in cadrul try:

```java
try {
   someLock.lock();
   .....
}
finally {
   someLock.unlock();
}
```

## Rezolvare

Daca someLock.lock() se afla in blocul try atunci, este posibil sa apara o exceptie, deoarece nu am obtinut lock-ul. Daca exceptia nu e tratata corect, cand ajungem in finally si cand se apeleaza someLock.unlock()
va aparea iar eroare, deoarece nu s-a executat comanda lock().
Aceasta problema ar putea fi rezolvata daca in finally am avea:

```java
if(Thread.holdsLock(someLock)){
     someLock.unlock();
}
```

Daca lock() se afla inainte de blocul try, in cazul care va fi aruncata vreo execeptie, atunci nu se mai incearca apelarea comenzii de unlock(). Cu alte cuvinte, o exceptie netratata nu ar trebui sa influenteze apelarea incorecta a lui unlock().
