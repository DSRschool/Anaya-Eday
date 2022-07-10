ordenacionRapida [] = []
ordenacionRapida (primero:resto) = 
		ordenacionRapida menores ++ iguales ++ ordenacionRapida mayores
	where
		menores = [n | n <- resto, n < primero]
		iguales = [n | n <- resto, n == primero] ++ [primero]
		mayores = [n | n <- resto, n > primero]
main =  print(ordenacionRapida [3, 8, 2, 5, 7, 4, 6, 1, 9])