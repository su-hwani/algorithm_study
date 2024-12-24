# import sys
# input = sys.stdin.readline

# word = str(input()).strip()
# boom = str(input()).strip()

# force_stop = False

# while True:
#     before_length_word = len(word)
#     if before_length_word == 0:
#         force_stop = True
#         break
#     re_word_list = word.split(boom)
#     re_word = ""
#     for i in re_word_list:
#         re_word += i
    
#     word = re_word
#     after_length_word = len(word)
    
#     if before_length_word == after_length_word:
#         break

# if force_stop:
#     print('FRULA')
# else:
#     print(word)

import sys
input = sys.stdin.readline

word = str(input()).strip()
boom = str(input()).strip()

word_list = []
len_boom = len(boom)

for i in range(len(word)):
    word_list.append(word[i])
    if boom[-1] == word_list[-1] and len(word_list) >= len(boom):
        can_continue = True
        for k in range(-1, -len_boom-1, -1):
            if boom[k] != word_list[k]:
                can_continue = False
                break
        if can_continue:
            for k in range(len_boom):
                word_list.pop()

if len(word_list):
    for i in word_list:
        print(i, end="")
else:
    print("FRULA")