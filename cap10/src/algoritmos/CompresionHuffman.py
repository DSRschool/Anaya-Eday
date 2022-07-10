import collections
import heapq

def probabilidades(contenido):
    total = len(contenido) + 1
    tablaHash = collections.Counter(contenido)
    res = {}
    for char, cont in tablaHash.items():
        res[char] = float(cont)/total
    res['end'] = 1.0/total
    return res

def arbol(probs):
    # Preparación de la cola, ordenada por prioridad y profundidad
    cola = []
    for simbolo, prob in probs.items():
        heapq.heappush(cola, (prob, 0, simbolo))

    # Construcción del árbol
    while len(cola) > 1:
        nodo1 = heapq.heappop(cola) # El símbolo menos probable
        nodo2 = heapq.heappop(cola) # El segundo menos probable

        # Creación del nuevo nodo, unión de los dos menos probables
        nuevoNodo = (
            nodo1[0] + nodo2[0], 
            max(nodo1[1], nodo2[1]) + 1, 
            [nodo1, nodo2])
        heapq.heappush(cola, nuevoNodo)
    return cola[0]
    
def diccionario(arbol):
    res = {}
    pilaBusqueda = []
    
    # El último elemento de la lista es el prefijo!
    pilaBusqueda.append(arbol + ("", )) 
    while len(pilaBusqueda) > 0:
        elem = pilaBusqueda.pop()
        if type(elem[2]) == list:
            # Nodo con hijos
            prefix = elem[-1]
            # El hijo izquierdo tiene "1" en el prefijo
            pilaBusqueda.append(elem[2][1] + (prefix+"1", ))
            # El hijo derecho tiene "0" en el prefijo
            pilaBusqueda.append(elem[2][0] + (prefix+"0", ))
            continue
        else:
            # Nodo hoja
            codigo = elem[-1]
            res[elem[2]] = codigo
        pass
    return res
    
def comprimir(dicc, contenido):
    res = "1"
    for letra in contenido:
        codigo = dicc[letra]
        res = res + codigo
    res = res + dicc['end']
    # Agregamos ceros para que la longitud del resultado sea un múltiplo de 8
    res = res + (len(res) % 8 * "0")
    return int(res, 2) # Convertimos el string en base 2 a entero
    
def descomprimir(dicc, comprimido):
    dic = dict(zip(dicc.values(), dicc.keys())) # giramos diccionario para decodificar
    res = []
    length = comprimido.bit_length() - 1
    if comprimido >> length != 1:
        raise Error("¡Fichero corrupto!")
    done = False
    while length > 0 and not done:
        shift = length - 1
        while True:
            num = comprimido >> shift
            bitnum = bin(num)[3:] # Quitamos '0b1' - el 1 inicial y el 0b de formato
            if bitnum not in dic:
                shift -= 1
                continue
            char = dic[bitnum]
            if char == 'end':
                done = True
                break
            res.append(char)
            comprimido = comprimido - ((num - 1) << shift)
            length = shift
    return ''.join(res)
    
def compresion(texto):
    probs = probabilidades(texto)
    arb = arbol(probs)
    dicc = diccionario(arb)
    res = comprimir(dicc, texto)
    rec = descomprimir(dicc, res)
    return res
    
    
def compresionVerbose(texto):
    probs = probabilidades(texto)
    print("probabilidades: ")
    print(probs)

    arb = arbol(probs)
    print("árbol: ")
    print(arb)

    dicc = diccionario(arb)
    print("diccionario:")
    print(dicc)
    
    res = comprimir(dicc, texto)

    rec = descomprimir(dicc, res) 
    print("descodificado: ")
    print(rec)
    return res
    
def bytesDe(i):
    return (i.bit_length() + 7) // 8    

texto0 = "CUANDO DIGO DIEGO, DIGO DIGO, CUANDO DIGO DIGO, DIGO DIEGO."
res0 = compresion(texto0)
print(res0)
print(str(len(texto0)) + " vs " + str(bytesDe(res0)))