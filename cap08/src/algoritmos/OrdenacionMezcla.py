def ordenacionMezcla(lista):
    if len(lista) <= 1:
        return lista

    centro = (int)(len(lista) / 2)
    izquierda = []
    derecha = []

    for i in range(centro):
        izquierda.append(lista[i])

    for i in range(centro, len(lista)):
        derecha.append(lista[i])
     
    izquierda = ordenacionMezcla(izquierda)
    derecha = ordenacionMezcla(derecha)
    solucion = mezcla(izquierda, derecha)
    return solucion

def mezcla(izquierda, derecha):
    indexIz = 0
    indexDr = 0
    solucion = []

    while indexIz < len(izquierda) and indexDr < len(derecha):
        if izquierda[indexIz] < derecha[indexDr]:
            solucion.append(izquierda[indexIz])
            indexIz += 1
        else:
            solucion.append(derecha[indexDr])
            indexDr += 1

    while indexIz < len(izquierda):
        solucion.append(izquierda[indexIz])
        indexIz += 1

    while indexDr < len(derecha):
        solucion.append(derecha[indexDr])
        indexDr += 1
    
    return solucion

ejemplo = [7, 5, 4, 1, 9, 8, 2, 3]
ordenada = ordenacionMezcla(ejemplo)
print(ordenada)
