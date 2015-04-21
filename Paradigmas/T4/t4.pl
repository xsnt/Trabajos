pobre(bernado).
pobre(bia).
pobre(pedro).
pobre(maria).
rico(henrique).
rico(adriano).
rico(alice).
rico(caren).
insano(adriano).
insano(maria).
vitima(anita)
casal(bernado, anita).
casal(bernado, caren).
casal(pedro, anita).
casal(pedro, alice).
casal(henrique, alice).
casal(henrique, maria).
casal(adriano, maria).
casal(maria, caren).
segunda(pedro, sm).
segunda(caren, poa).
segunda(alice, ap).
segunda(bernado, sm).
segunda(maria, ap).
segunda(henrique, ap).
segunda(bia, ap).
segunda(adriano, ap).
terca(caren, poa).
terca(pedro, sm).
terca(adriano, ap).
terca(alice, poa).
terca(henrique, poa).
terca(bia, poa).
terca(bernado, sm).
terca(maria, sm).
quarta(henrique, ap).
quarta(pedro, poa).
quarta(caren, poa).
quarta(bia, poa).
quarta(adriano, sm).
quarta(alice, poa).
quarta(bernado, poa).
quarta(maria, sm).
quinta(adriano, ap).
quinta(alice, ap).
quinta(pedro, sm).
quinta(caren, sm).
quinta(henrique, ap).
quinta(bia, sm).
quinta(bernado, sm).
quinta(maria, sm).
sexta(caren, ap).
sexta(pedro, ap).
sexta(henrique, ap).
sexta(bia, ap).
sexta(adriano, ap).
sexta(alice, ap).
sexta(bernado, ap).
sexta(maria, ap).




dinheiro(X) :- pobre(X).
rouboarma(X) :-  quinta(X, porto); quarta(X, santa); quinta(X, ap); quarta(X, ap).
roubochave(X) :- segunda(X, santa); terca(X, porto).
estavanoap(X) :- quinta(X, ap); sexta(X, ap).
acesso(X) :- rouboarma(X), roubochave(X), estavanoap(X).
ciumes(X,Y) :- casal(X, Y), casal(Y, _); casal(Y, X), casal(X, _); casal(A, X), casal(Y, A); casal(A, X), casal(A, Y).
motivo(X) :- dinheiro(X); insano(X); ciumes(X, anita).


assassino(X) :- motivo(X), acesso(X).