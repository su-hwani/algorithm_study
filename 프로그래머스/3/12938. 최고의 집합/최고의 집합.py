def solution(n, s):
    
    
    base_number = s // n
    added_number = s % n 
    numbers = [base_number for _ in range(n)]
    
    for i in range(added_number): 
        numbers[i] += 1
    
    numbers.sort() 
    
    if numbers[0] == 0 or sum(numbers) != s :
        return [-1]
    
    answer = numbers
    return answer