def solution(prices):
    q = [] # price, index
    score_by_index = {} # index: score
    
    for i in range(0, len(prices)):
        if len(q) == 0 or q[-1][0] <= prices[i]:
            q.append( (prices[i], i) )
        else:
            
            while q:
                if q[-1][0] > prices[i]:
                    small_price, small_index = q.pop()
                    score_by_index[small_index] = i - small_index
                else:
                    break
            
            q.append( (prices[i], i) )
    
    len_prices = len(prices)
    while q:
        price, index = q.pop()
        score_by_index[index] = len_prices - index -1
    answer = [ x[1] for x in sorted(list(score_by_index.items()))]
    
    return answer