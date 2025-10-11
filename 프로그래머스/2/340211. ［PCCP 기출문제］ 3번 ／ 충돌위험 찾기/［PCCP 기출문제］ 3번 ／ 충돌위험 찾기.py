def solution(points, routes):
    graph = [
        [{} for _ in range(101)] for __ in range(101)
    ]
    ans = 0
    
    for route in routes: 
        all_path = []
        
        all_path.append( (points[route[0]-1][0], points[route[0]-1][1]) )
        
        for r in range(0, len(route)-1): 
            p = fun1(points[route[r]-1][0], points[route[r]-1][1], points[route[r+1]-1][0], points[route[r+1]-1][1])
            all_path.extend(p)
        
        for r in range(len(all_path)): 
            if r in graph[all_path[r][0]][all_path[r][1]]: 
                graph[all_path[r][0]][all_path[r][1]][r] += 1
                
                if graph[all_path[r][0]][all_path[r][1]][r] == 2:
                    # print(all_path[r][0] , all_path[r][1])
                    ans += 1
            else:
                graph[all_path[r][0]][all_path[r][1]][r] = 1
        # print(all_path)
    
            
    return ans


def fun1(now_x, now_y, end_x, end_y): 

    path = []
    
    if now_x > end_x: 
        for _ in range(now_x - end_x):
            now_x -= 1
            path.append( (now_x, now_y) )
    elif now_x < end_x: 
        for _ in range(end_x - now_x):
            now_x += 1
            path.append( (now_x, now_y) ) 
    else:
        pass 
    
    if now_y > end_y:
        for _ in range(now_y - end_y): 
            now_y -= 1
            path.append( (now_x, now_y) )
    elif now_y < end_y:
        for _ in range(end_y - now_y): 
            now_y += 1
            path.append( (now_x, now_y) )
    else:
        pass 
    
    return path
            
            
        