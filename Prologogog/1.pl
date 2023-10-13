% Ejercicio 1: sumlist(L, S)

sumlist([], 0).
sumlist([X|L], S) :-
  X + sumlist(L, S1),
  S is S1.

?- sumlist([1, 2, 3], S).
S = 6
?- sumlist([], S).
S = 0

% Ejercicio 2: subconj(S, S1)

subconj([], []).
subconj([X|S], S1) :-
  member(X, S1),
  subconj(S, S1).

?- subconj([1, 2], [1, 2, 3]).
true
?- subconj([1, 2], [3, 4, 5]).
false

% Ejercicio 3: aplanar(L,L2)

aplanar([], []).
aplanar([X|L], L2) :-
  aplanar(L, L1),
  append(L1, [X], L2).

?- aplanar([1, [2, [3]], 4], L).
L = [1, 2, 3, 4]
?- aplanar([], L).
L = []

% Ejercicio 4: partir(Lista, Umbral, Menores, Mayores)

partir([], _, [], []).
partir([X|L], Umbral, Menores, Mayores) :-
  X < Umbral,
  partir(L, Umbral, Menores, [X|Mayores]).
partir([X|L], Umbral, Menores, Mayores) :-
  X >= Umbral,
  partir(L, Umbral, [X|Menores], Mayores).

?- partir([2,7,4,8,9,1], 6, Menores, Mayores).
Menores = [2,4,1]
Mayores = [7,8,9]
?- partir([], _, Menores, Mayores).
Menores = []
Mayores = []

% Ejercicio 5: sub_cadenas(“la”, [“la casa, “el perro”, “pintando la cerca”],Filtradas)

sub_cadenas(Subcadena, Lista, Filtradas) :-
  member(L, Lista),
  string_contains(L, Subcadena),
  append(Filtradas, [L], Filtradas1),
  sub_cadenas(Subcadena, Filtradas1, Filtradas).
sub_cadenas(_, [], []).

?- sub_cadenas("la", ["la casa, "el perro", "pintando la cerca"],Filtradas).
True
Filtradas = ["la casa, "pintando la cerca"]