def solution(routes):
    routes.sort()

    common = []
    cur = [routes[0][0], routes[0][1]]

    for i in range(0, len(routes)):
        route = routes[i]
        start, end = route[0], route[1]

        if start <= cur[1]:
            cur[0] = start
            cur[1] = min(end, cur[1])
        else:
            common.append((cur[0], cur[1]))  # cur의 복사본을 추가
            cur[0] = start
            cur[1] = end

    
    common.append((cur[0], cur[1]))

    
    return len(common)

