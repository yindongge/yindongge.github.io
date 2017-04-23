-- 根据经纬度计算距离
CREATE DEFINER=`root`@`%` FUNCTION `f_distance`(`longitude1` double,`latitude1` double,`longitude2` double,`latitude2` double) RETURNS double
BEGIN

	RETURN round(6378.138*2*asin(
            sqrt(
                pow(
                    sin(
                        (latitude1*pi()/180-latitude2*pi()/180)
                    /2)
                ,2)
                +
                cos(latitude1*pi()/180)*cos(latitude2*pi()/180)
                *
                pow(
                    sin(
                        (longitude1*pi()/180-longitude2*pi()/180)
                    /2)
                ,2))
             )
        *1000);
END