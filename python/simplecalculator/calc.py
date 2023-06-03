# Simple calculator program

# This function adds two numbers
def ajout(x, y):
    return x + y

# This function subtracts two numbers
def soustraire(x, y):
    return x - y

# This function multiplies two numbers
def multiplier(x, y):
    return x * y

# This function divides two numbers
def diviser(x, y):
    return x / y

print("Select the operation.")
print("1.Addition")
print("2.Subtraction")
print("3.Multiplication")
print("4.Division")

while True:
    # Taking the user's view
    choix = input("Enter the choice (1/2/3/4): ")

    # Vérifier si le choix est l'une des quatre options
    if choix in ('1', '2', '3', '4'):
        num1 = float(input("Enter the first number : "))
        num2 = float(input("Enter the second number : "))

        if choix == '1':
            print(num1, "+", num2, "=", ajout(num1, num2))

        elif choix == '2':
            print(num1, "-", num2, "=", soustraire(num1, num2))

        elif choix == '3':
            print(num1, "*", num2, "=", multiplier(num1, num2))

        elif choix == '4':
            print(num1, "/", num2, "=", diviser(num1, num2))
        break
    else:
        print("Invalid entry")