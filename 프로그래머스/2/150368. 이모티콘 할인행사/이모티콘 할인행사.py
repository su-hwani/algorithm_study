def solution(users, emoticons):
    answer = []
    
    ans_count, ans_money = backtracking(users, emoticons, [])
    
    # print(f"count: {ans_count} money: {ans_money}")
    
    
    
    return [ans_count, ans_money ]

def backtracking(users, emoticons, emoticons_percents): 
    
    if len(emoticons) == len(emoticons_percents): 
        
        user_enroll_count = 0
        user_enroll_money = 0
        
        for user in users: 
            
            sell_percentage, upper_money = user[0], user[1]
            total_money = 0
            
            for emoti_idx in range(len(emoticons)): 
                if emoticons_percents[emoti_idx] >= sell_percentage: 
                    total_money += emoticons[emoti_idx] - (emoticons[emoti_idx] * emoticons_percents[emoti_idx] // 100)
            if total_money >= upper_money: 
                user_enroll_count += 1
            else: 
                user_enroll_money += total_money 
        # print(f"{emoticons_percents} count: {user_enroll_count} money: {user_enroll_money}")
        return user_enroll_count, user_enroll_money 
    
    fixed_percentages = [10, 20, 30, 40]
    
    cur_max_enroll_count, cur_max_enroll_money = 0, 0
    
    for i in fixed_percentages: 
        emoticons_percents.append(i)
        cmec, cmem = backtracking(users, emoticons, emoticons_percents)
        
        if cmec > cur_max_enroll_count: 
            cur_max_enroll_count, cur_max_enroll_money = cmec, cmem
        elif cmec == cur_max_enroll_count and cmem > cur_max_enroll_money: 
            cur_max_enroll_money = cmem
        
        emoticons_percents.pop()
    
    return cur_max_enroll_count, cur_max_enroll_money 
        
                    

    
    