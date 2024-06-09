import React from 'react';
import { Card, CardContent, IconButton, Typography } from '@mui/material';
import Box from '@mui/material/Box';





const CardStatisticProps = {
    // icon: React component representing the icon (e.g., BookingSharp from MUI)
    icon: React.ComponentType,
    // title: String representing the card title
    title: String,
    // value: String or number representing the card value
    value: String ,
    // textSub (optional): String representing the subtext
    textSub: String,
  };
//const CardStatistic = ({ icon: Icon, title, value, textSub,boxColor })
  const CardStatistic = ({  icon: Icon, title, value, textSub,boxColor }) => {
    return (
     
      <>
      <Card sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '16px', minWidth: '200px', width:'230px',marginLeft:'50px' }}>
      
      <Box
      borderRadius="4px"
      display="flex"
      justifyContent="center"
      alignItems="center"
      width="3rem"
      height="3rem"
      mt={-5}
        sx={{
          marginTop:'-100px',
          backgroundColor: boxColor,
          
          
        }}
      >
        <IconButton aria-label="icon" fontSize="medium" style={{ color: 'white' }}>
          < Icon /> 
        </IconButton>
      </Box>
      <CardContent sx={{ display: 'flex', flexDirection: 'column', padding: '15px' }}>
        <Box sx={{marginBottom:'30px',justifyContent: 'flex-end', textAlign: 'right'}}>
        <Typography variant="h6" component="div">
          {title}
        </Typography>
        <Typography variant="h4" component="div">
          {value}
        </Typography>
        </Box>
        <Box sx={{ display: 'flex', marginLeft:'-115px', marginBottom:'-20px' }}>
      {textSub && <Typography variant="body2" color="text.secondary" component="p">
        {textSub}
      </Typography>}
    </Box>
      </CardContent>
      </Card>
    </>
    );
  };

  
export default CardStatistic;
 {/**/}