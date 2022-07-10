def fib(lim):
    serie = [0, 1]
    i = 2
    alcanzado = False 
    while not alcanzado:
        aux = serie[i-2] + serie[i-1] 
        alcanzado = aux > lim
        if not alcanzado:
            serie.append(aux)
        i = i + 1 
    return serie
 
print(fib(1000))