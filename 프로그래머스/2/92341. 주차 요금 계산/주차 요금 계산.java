import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> totalTimeMap = new HashMap<>();
        Map<String, Integer> curTimeMap = new HashMap<>();
        
        for (String record: records) {
            String[] recordInfo = record.split(" ");
            
            String curTime = recordInfo[0];
            String number = recordInfo[1];
            String value = recordInfo[2];
            
            if (value.length() == 2) {
                curTimeMap.put(number, getMin(curTime));
            } else {
                int startTime = curTimeMap.get(number);
                if (totalTimeMap.containsKey(number)) {
                    totalTimeMap.put(number, totalTimeMap.get(number) + getMin(curTime) - startTime);
                } else {
                    totalTimeMap.put(number, getMin(curTime) - startTime);
                }
                curTimeMap.remove(number);
            }
        }
        
        List<String> restNumber = new ArrayList<>(curTimeMap.keySet());
        int endTime = getMin("23:59");
        for (int i = 0; i < restNumber.size(); i++) {
            int u = endTime - curTimeMap.get(restNumber.get(i));
            String number = restNumber.get(i);
            if (totalTimeMap.containsKey(number)) {
                totalTimeMap.put(number, totalTimeMap.get(number) + u);
            } else {
                totalTimeMap.put(number, u);
            }
        }
        
        List<String> allNumber = new ArrayList<>(totalTimeMap.keySet());
        
        int[] answer = new int[allNumber.size()];
        
        Collections.sort(allNumber);
        
        for (int i = 0; i < allNumber.size(); i++) {
            String carNum = allNumber.get(i);
            int totalFee = getFee(fees, totalTimeMap.get(carNum));
            answer[i] = totalFee;
        }
        
        return answer;
    }
    
    public int getMin(String time) {
        String[] timeInfo = time.split(":");
        
        int hour = Integer.parseInt(timeInfo[0]);
        int min = Integer.parseInt(timeInfo[1]);
        
        return hour * 60 + min;
    }
    
    public int getFee(int[] fees, int usedTime) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int perTime = fees[2];
        int perFee = fees[3];
        
        if (usedTime <= basicTime) return basicFee; 
        
        usedTime -= basicTime;
        
        int totalFee = (int) Math.ceil((double) usedTime / perTime);
        return totalFee * perFee + basicFee;
    }
}