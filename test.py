

commands = ["prev", "next", "next"]
video_len = "10:55"
pos = "00:05"
skip = "00:10"
op_start = "00:15"
op_end = "06:55"


def TempTime(stringTime):
    stringTime = list(map(int, stringTime.split(":")))
    answer = stringTime[0]*100 + stringTime[1]
    return answer

def StrTime(tempTime):
    answer = []
    answer.append(tempTime//100)
    answer.append(tempTime%100)
    strTime = "{:02d}:{:02d}".format(answer[0], answer[1])
    return strTime

def IsNextOver(tempTime):
    if ((tempTime%100) >= 60):
        tempTime += 40
    return tempTime
def IsPrevOver(tempTime):
    if ((tempTime%100) >= 60):
        tempTime -= 40
    return tempTime  
# 둘의 차이를 어떻게 조건문으로?
# 1. 10초단위이니 그 사이를 조건문으로
# 2. 
# next에서 1370 의 경우에는 +40
# prev에서 1290 의 경우에는 -40

parsed_len = TempTime(video_len)
parsed_pos = TempTime(pos)
skip = 10
parsed_start = TempTime(op_start)
parsed_end = TempTime(op_end)


# First pos check if clause
if (parsed_pos >= parsed_start and parsed_pos <= parsed_end):
    parsed_pos = parsed_end

for i in commands:
    if(i == "next"):
        parsed_pos += skip
        parsed_pos = IsNextOver(parsed_pos)   
    elif(i == "prev"):
        parsed_pos -= skip
        parsed_pos = IsPrevOver(parsed_pos)

    if (parsed_pos < 0):
        parsed_pos = 0
    if (parsed_pos >= parsed_len):
        parsed_pos = parsed_len

if (parsed_pos >= parsed_start and parsed_pos <= parsed_end):
    parsed_pos = parsed_end

print(StrTime(parsed_pos))


    
