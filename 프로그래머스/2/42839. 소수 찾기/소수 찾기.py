import math
from itertools import combinations, permutations

def is_sosu(num) -> bool: 
    
    if num == 1 or num == 0: 
        return False 
    
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0: 
            return False
    return True 

def solution(numbers):
    answer = set([])
    dic = {} 
    
    numbers = list(numbers)
    
    for i in range(1, len(numbers) + 1): 
        new_numbers = list(permutations(numbers, i))
    
        for number in new_numbers: 
            new_num = ""
            for k in number: 
                new_num += k
            new_int_num = int(new_num)
            
            
            if new_int_num in dic: 
                continue 
                
            if is_sosu(new_int_num): 
                answer.add(new_int_num)
            
    
    
    return len(answer)

