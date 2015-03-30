--Escreva uma função geraPotencias :: Int -> [Int], que gere uma lista com as potências de 2,
--com expoente de n até 0, onde n é o argumento para a função. Use a sintaxe de list comprehension. 
geraPotencias:: Int -> [Int]
geraPotencias x = [2^x | x <- [x, x-1..0]]


--Escreva uma função usando list comprehension, para adicionar um sufixo às strings contidas numa lista. Exemplo:
-- addSuffix "@inf.ufsm.br" ["fulano","beltrano"]
--["fulano@inf.ufsm.br","beltrano@inf.ufsm.br"]
addSuffix :: String -> [String] -> [String] 
addSuffix suf pref = [ x++suf | x <- pref ]


--Escreva uma função  que receba uma lista de idades, selecione as que são maiores que 20 e, 
--para cada uma das selecionadas, calcule o ano de nascimento correspondente 
--(aproximado). Use a sintaxe de list comprehension.
anosDeNascimento :: [Int] -> [Int]
anosDeNascimento id = [(2015-)x | x <- x, x>=20]