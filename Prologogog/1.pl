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

% Define individuals with their characteristics
person(john, smith, [1, 1, 0, 0, 1, 0, 0, 1, 1, 0]).
person(anna, gomez, [0, 1, 1, 0, 0, 1, 0, 1, 0, 1]).
person(joseph, rodriguez, [1, 0, 1, 0, 1, 1, 0, 0, 1, 1]).
person(mary, lopez, [0, 0, 1, 1, 1, 0, 0, 1, 0, 1]).
person(louis, fernandez, [1, 0, 0, 0, 1, 1, 0, 1, 0, 1]).
person(anna, martinez, [0, 1, 0, 0, 1, 1, 0, 1, 1, 0]).
person(john, soto, [1, 0, 1, 1, 0, 0, 1, 0, 1, 0]).
person(david, castillo, [0, 1, 1, 0, 1, 0, 1, 0, 0, 1]).
person(sophia, garcia, [1, 1, 0, 0, 0, 1, 1, 0, 1, 0]).
person(philip, ramirez, [0, 0, 1, 1, 0, 1, 1, 0, 0, 1]).

% Define connections between individuals
connections(philip, anna, 3).
connections(anna, david, 2).
connections(philip, john).
connections(john, david, 4).

% Define the predicate for finding the shortest route between two individuals
shortest_route(X, Y, (Route, Weight)) :-
    shortest_route_aux(X, Y, [X], Route, 0, Weight).

shortest_route_aux(X, X, Route, Route, Weight, Weight).
shortest_route_aux(X, Y, Visited, Route, CurrentWeight, Weight) :-
    connections(X, Z, P1),
    \+ member(Z, Visited),
    NewWeight is CurrentWeight + P1,
    shortest_route_aux(Z, Y, [Z | Visited], Route, NewWeight, Weight).

% Define a sample chromosome to compare with
sample([1, 0, 1, 0, 0, 1, 1, 1, 0, 1]).

% Calculate the similarity between two chromosomes using Hamming distance
chromosome_similarity(C1, C2, Similarity) :-
    hamming_distance(C1, C2, Distance),
    Similarity is (100 - Distance * 10).

hamming_distance([], [], 0).
hamming_distance([X|Xs], [Y|Ys], Distance) :-
    hamming_distance(Xs, Ys, RestDistance),
    Distance is RestDistance + abs(X - Y).

% Find the most similar person to the given sample chromosome
find_similar_person(Person, Percentage) :-
    sample(Sample),
    findall((Name, Similarity), (person(Name, _, Chromosomes), chromosome_similarity(Chromosomes, Sample, Similarity)), SimilarityList),
    max_member((Person, Percentage), SimilarityList).
