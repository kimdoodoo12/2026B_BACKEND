import datetime

def isOver(time1 ,time2):
    if (time2 >= 60):
        time2 = 0
        time1 += 1
    elif (time1 >= 60):
        time1 = 0


commands = ["next", "prev", "next"]
video_len = "34:33"
pos = "13:00"
skip = "00:10"
# The first 'datetime' is the module, the second is the class
parsed_len = list(map(int, video_len.split(":")))
parsed_pos = list(map(int, pos.split(":")))
skip = list(map(int, skip.split(":")))

for i in commands:
    if(i == "next"):
        temp = parsed_pos[1] + skip[1]
        if (temp >= 60):
            parsed_pos[1] += (temp-60)
            parsed_pos[0] += 1
        else:
            parsed_pos[1] = temp
        
    elif(i == "prev"):
        temp = parsed_pos[1] - skip[1]
        if (temp <= 0):
            parsed_pos[1] += (temp+60)
            parsed_pos[0] -= 1
        else:
            parsed_pos[1] = temp
