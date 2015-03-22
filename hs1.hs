--1 Escreva uma função hasEqHeads :: [Int] -> [Int] -> Bool que verifica se as 2 listas possuem o mesmo primeiro elemento. 
hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads x y
	| (head x) == (head y) = True
	| otherwise = False

--2 Observe a função abaixo, que eleva ao cubo cada elemento da lista, produzindo outra lista.
pot3 :: [Int] -> [Int]
pot3 [] = []
pot3 ns = (head ns)^3 : pot3 (tail ns)


--3 Escreva uma função recursiva add10, que adicione a constante 10 a cada elemento de uma lista, produzindo outra lista
add10 :: [Int] -> [Int]
add10 [] = []
add10 x = (head x)+10 : add10 (tail x)

--4 Escreva uma função recursiva addComma, que adicione uma vírgula no final de cada string contida numa lista
addComma :: [String] -> [String]
addComma [] = []
addComma x = ((head x)++","): addComma (tail x)

--5 Refaça os 2 exercícios anteriores usando a função de alta ordem 'map'.

--3
add10Map :: [Int] -> [Int]
add10Map x = map (+10)x

--4
addComMap :: [String] -> [String]
addComMap x = map (++",")x

--6 Crie uma função htmlListItems :: [String] -> [String], que receba uma lista de strings e retorne outra lista 
--contendo as strings formatadas como itens de lista em HTML.
htmlListItems :: [String] -> [String] 
htmlListItems x = map ((map (++"<LI>")x)"</LI>"++)x

--7 Crie uma função recursiva charFound :: Char -> String -> Bool, que verifique se o caracter (primeiro argumento) está contido na string (segundo argumento).
charFound :: Char -> String -> Bool
charFound _ "" = False 
charFound x y = if x == (head y) 
	then True 
	else charFound x (tail y) 

--8
charFoundMp :: Char -> String -> Bool
charFoundMp x y
	|filter (== x) y /= [] = True	
	|filter (== x) y == [] = False
	
--9
diferenca :: [Int] -> [Int] -> [Int]
diferenca [] [] = []
diferenca x y = ZipWith (-) a b

-- Alta Ordem
--1
contas :: [Int] -> [Int]
contas [] = []
contas x = map (\x -> 2*x+1) x

--2
contas2 :: [Int] -> [Int] -> [Int]
contas2 [] [] = []
contas2 x y = zipWith (\a b -> 4*a+2*b+1) a b

--3
str10 :: [String] -> [String]
str10 [] = []
str10 (a:b) = take 10 (a ++ (repeat '.')) : str10 b

--4
nasc :: [Int] -> [Int]
nasc [] = []
nasc a = map(2015-)(filter(>20)a)
