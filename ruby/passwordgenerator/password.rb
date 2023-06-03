# passwordgenerator.rb
#Interactive, written in Ruby, this application generates a password based on a word 
#and the size of the password you enter.


alpha = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz?/\\ |}{[]!@# $%^&*()1234567890_-+=<>,.`~'':;".split(//)
passwrd = ""
puts "What word keyword/theme do you want the password to have?:"
theme = gets.chomp
puts "How long do you want the passwrd to be?(Must be longer than the theme.):"
passwrdlen = gets.chomp.to_i
if passwrdlen > theme.length
  passwrdlen -= theme.length
  passwrd += theme
  while passwrdlen > 0
    passwrd += alpha.sample
    passwrdlen -= 1
  end
  puts passwrd
else
  puts "Can't use the theme since password length is shorter than the theme."
end