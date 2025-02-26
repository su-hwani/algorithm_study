def solution(phone_book):
    
    phone_book.sort()
    answer = True
    
    for i in range(1, len(phone_book)):
        pre_num = phone_book[i-1]
        cur_num = phone_book[i]
        if pre_num == cur_num[:len(pre_num)]:
            answer = False
            break 
        
    return answer