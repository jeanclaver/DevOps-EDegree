
def convert():
    operation = input('''
Please type in weight conversion operation you would like to complete:
1 for Kilogram -> Gram = (kilogram_value * 1000) grams
2 for Gram -> Kilogram = (gram_value / 1000) kilograms
3 for Pound -> Ounce = (pound_value * 16) oz
4 for Ounce -> Pound = (ounce_value / 16) lb
5 for Kilogram -> Pound = (kilogram_input * 2.205) lb
6 for Pound -> Kilogram = (pound_input / 2.205) kg
''')

# Kilogram -> Gram = (kilogram_value * 1000) grams

    if operation == '1':
        kgweight = input("What is the weight in kilograms?")
        gramweight = (float(kgweight) * 1000)
        print('Converting the weight from kilogram in gram')
        print(f"{gramweight} gram ")

# Gram -> Kilogram = (gram_value / 1000) kilograms
    elif operation == '2':
          gramweight = input("What is the weight in grams?")
          kgweight = (float(gramweight) / 1000)
          print('Converting the weight from gram in kilogram')
          print(f"{kgweight} kg ")

# Pound -> Ounce = (pound_value * 16) oz
    elif operation == '3':
          poundweight = input("What is the weight in Pounds?")
          ounceweight = (float(poundweight) / 1000)
          print('Converting the weight from Pound  in Ounce')
          print(f"{ounceweight} oz ")

# Ounce -> Pound = (ounce_value / 16) lb
    elif operation == '4':
          ounceweight = input("What is the weight in ounce?")
          poundweight = (float(ounceweight) / 16)
          print('Converting the weight from Ounce in Pounds')
          print(f"{poundweight} lbs ")

# Kilogram -> Pound = (kilogram_input * 2.205) lb
    elif operation == '5':
          kgweight = input("What is the weight in kilograms?")
          poundweight = (float(kgweight) * 2.205)
          print('Converting the weight from kilogram in Pounds')
          print(f"{poundweight} lbs ")
# Pound -> Kilogram = (pound_input / 2.205) kg
    elif operation == '6':
          poundweight = input("What is the weight in Pounds?")
          kgweight = (float(poundweight) / 2.2046)
          print('Converting the weight from Pound in kilogram')
          print(f"{kgweight} kg ")

    else:
        print('You have not typed a valid number, please run the program again.')      
 
# Add again() function to calculate() function
    again()
def again():
    convert_again = input('''
Do you want to convert again?
Please type Y for YES or N for NO.
''')    
    if convert_again.upper() == 'Y':
        convert()
    elif convert_again.upper() == 'N':
        print('Thank You ! See you later.')
    else:
        again()

convert()