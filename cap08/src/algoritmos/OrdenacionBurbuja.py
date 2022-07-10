def ordenacionBurbuja(lista):
    n = len(lista)
    for i in range(n-1):
        for j in range(0, n-i-1):
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]
 
ejemplo = [5, 3, 8, 4, 2]
ordenacionBurbuja(ejemplo)
print(ejemplo)