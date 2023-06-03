# In this project, we will write a password generator in Python.
# The passwords will be random and will generate a new password each time 
# the user requests a new password with a mixture of lower case letters, upper 
# case letters, numbers and symbols.  
# In order to make our application a bit interactive, the user will have to indicate 
# the strength of his password. For weak passwords, the application will return a simple password
# from a list.

import random 

def password_generator():
  user_input = input("For a strong password, type 'strong'. For a weak one, type 'weak': ")
  if user_input.lower() == 'weak': 
    return random.choice(['password', 'mamalova', 'iloveyou','azerty','qwerty'])

  else:
    letters = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ!@#$%^&*()?1234567890'
    password = ''.join(random.choices(letters, k=(random.randrange(8, 24))))
    return password
  
print(password_generator())