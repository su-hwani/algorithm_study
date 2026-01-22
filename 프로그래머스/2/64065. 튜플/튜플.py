def solution(s):
    
    s = s[2:-2]
    s = s.split("},{")
    s.sort(key=lambda x:len(x))
    
    answer = []
    last_append_item = None
    for i in s: 
        # print(f"last_append_item: {last_append_item}")
        if last_append_item: 
            cur_append_item = set(i.split(','))
            last_append = cur_append_item - last_append_item
            last_append = last_append.pop()
            
            answer.append(int(last_append))
            
            last_append_item = cur_append_item
            
            # print(f"last_append: {last_append}")
            continue 
            
        c = i.split(',')
        last_append_item = set(c)
        answer.append(int(c[0]))
        
    
    return answer


