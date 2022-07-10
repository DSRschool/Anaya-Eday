NO_ENCONTRADO = -1
def busquedaBinaria(lista, elem):
    return busquedaBinariaAux(lista, elem, 0, len(lista))
    
def busquedaBinariaAux(lista, elem, ini, fin):
    centro = ((fin - ini) // 2) + ini
    valorCentral = lista[centro]
    if valorCentral == elem:
        return centro
    if fin - ini <= 1:
        return NO_ENCONTRADO
    if valorCentral < elem:
        return busquedaBinariaAux(lista, elem, centro, fin)
    if valorCentral > elem:
        return busquedaBinariaAux(lista, elem, ini, centro)

test = [1, 3, 5, 7, 9]
for i in range (11):
    res = busquedaBinaria(test, i)
    if res == NO_ENCONTRADO:
        print("La lista no tiene " + str(i))
    else:
        print(str(i) + " está en la posición " + str(res))