NO_ENCONTRADO = -1
def busquedaBinaria(lista, elem):
    return busquedaBinariaAux(lista, elem, 0, len(lista), 0)
    
def busquedaBinariaAux(lista, elem, ini, fin, contador):
    contador = contador + 1
    centro = ((fin - ini) // 2) + ini
    valorCentral = lista[centro]
    if valorCentral == elem:
        return contador
    if fin - ini <= 1:
        return NO_ENCONTRADO
    if valorCentral < elem:
        return busquedaBinariaAux(lista, elem, centro, fin, contador)
    if valorCentral > elem:
        return busquedaBinariaAux(lista, elem, ini, centro, contador)

test = [1, 3, 5, 7, 9]
for i in range (11):
    res = busquedaBinaria(test, i)
    if res == NO_ENCONTRADO:
        print("La lista no tiene " + str(i))
    else:
        print("Hemos encontrado " + str(i) + " en " + str(res) + " paso(s)")