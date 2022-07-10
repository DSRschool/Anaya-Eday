NUM_CHARS = 256
 
def tablaUltimaPosicion(patron):
    ultPos = [-1] * NUM_CHARS
    for i in range(len(patron)):
        ultPos[ord(patron[i])] = i
    return ultPos
 
def buscar(texto, buscado):
    sol = []
    longBusc = len(buscado)
    longTexto = len(texto)

    ultPos = tablaUltimaPosicion(buscado)
    i = 0

    while i <= longTexto - longBusc:
        j = longBusc - 1
        while j >= 0 and buscado[j] == texto[i+j]:
            j -= 1 # mientras coincidan, vamos retrocediendo
        
        if j < 0: # si coinciden todas, lo hemos encontrado
            sol.append(i)
            if i + longBusc < longTexto:
                i += longBusc - ultPos[ord(texto[i+longBusc])] 
            else:
                i += 1
        else: # no lo hemos encontrado, saltamos
            i += max(1, j - ultPos[ord(texto[i+j])])
    return sol
 
print(buscar("abracadabra", "bra"))