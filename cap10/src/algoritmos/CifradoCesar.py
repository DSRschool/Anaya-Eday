BASE_MIN = ord('a')
BASE_MAY = ord('A')
LONG_ABC = 26

def cifrar(texto, despl):
    cifrado = ""
    for letra in texto:
        cifrado += cifrar_letra(letra, despl)
    return cifrado
    
def cifrar_letra(letra, despl):
    if letra.isupper():
        base = BASE_MAY
    elif letra.islower():
        base = BASE_MIN
    else:
        return letra # no ciframos las no letras
    return chr((ord(letra) - base + despl) % LONG_ABC + base)

for i in range (0, 27):
    print(str(i) + "> " + cifrar("Buenos dias", i))

print(cifrar("Buenos dias", 13))
print(cifrar(cifrar("Buenos dias", 13), 13))    