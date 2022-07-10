NO_ENCONTRADO = -1
def busquedaLineal(lista, elemento):
    for i in range(len(lista)):
        if lista[i] == elemento:
            return i # return true
    return NO_ENCONTRADO # return false
    
print(busquedaLineal([3, 8, 5, 7, 2], 7))