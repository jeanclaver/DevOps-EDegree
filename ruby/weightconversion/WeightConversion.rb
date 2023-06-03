#A ruby program for weight conversions
puts "A ruby program for weight conversions:"
loop do
  puts "--- Weight Conversion ---"
  puts "1. Kilogram -> Gram = (kilogram_value * 1000) grams"
  puts "2. Gram -> Kilogram = (gram_value / 1000) kilograms"
  puts "3. Pound -> Ounce = (pound_value * 16) oz"
  puts "4. Ounce -> Pound = (ounce_value / 16) lb"
  puts "5. Kilogram -> Pound = (kilogram_input * 2.205) lb"
  puts "6. Pound -> Kilogram = (pound_input / 2.205) kg"
  puts "7. Exit"
  print "Which operation you want to perform: "
  
  operation = gets.to_i
    # get option from user and convert into number
  break if operation ==7
  
  case operation
  when 1
    # Kilogram -> Gram = (kilogram_value * 1000) grams
    puts "What is the weight in kilograms?"
    kgweight = gets.to_i
    gramweight = kgweight* 1000
    puts "Converting the weight from kilogram in gram"
    puts "#{gramweight} gram"

  when 2
    # Gram -> Kilogram = (gram_value / 1000) kilograms
    puts "What is the weight in grams?"
    gramweight = gets.to_i
    kgweight = gramweight.to_f / 1000
    puts "Converting the weight from gram in kilogram"
    puts "#{kgweight} kg"
 when 3
    # Pound -> Ounce = (pound_value * 16) oz
    puts "What is the weight in Pounds?"
    poundweight = gets.to_i
    ounceweight = poundweight* 16
    puts "Converting the weight from Pound  in Ounce"
    puts "#{ounceweight} oz"
 when 4
    # Ounce -> Pound = (ounce_value / 16) lb
    puts "What is the weight in ounce?"
    ounceweight = gets.to_i
    poundweight = ounceweight.to_f / 16
    puts "Converting the weight from Ounce in Pounds"
    puts "#{poundweight} lbs"
 when 5
    # Kilogram -> Pound = (kilogram_input * 2.205) lb
    puts "What is the weight in kilograms?"
    kgweight = gets.to_i
    poundweight = kgweight * 2.205
    puts "Converting the weight from kilogram in Pounds"
    puts "#{poundweight} lbs"
 when 6
   # Pound -> Kilogram = (pound_input / 2.205) kg
    puts "What is the weight in Pounds?"
    poundweight = gets.to_i
    kgweight = poundweight.to_f / 2.205
    puts "Converting the weight from Pound in kilogram"
    puts "#{kgweight} kg"

  else
    puts "You have not typed a valid number, please run the program again."
      
  end
   puts ""   # needed to print next iteration in next line
end
