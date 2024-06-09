import React from "react";
import { useState } from 'react';
import Card from '@mui/material/Card';
import Stack from '@mui/material/Stack';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';
import Grid from '@mui/material/Grid';
import DeleteIcon from '@mui/icons-material/Delete';
import BorderColorIcon from '@mui/icons-material/BorderColor';
import SuppForm from './SuppForm';
const FrCardVert = () =>{
        const [open, setOpen] = useState(false); // State for modal visibility
      
        const handleDelete = () => {
          setOpen(true); // Open the modal on button click
        };
      
        const handleClose = () => {
          setOpen(false); // Close the modal
        };
    return(
        < Grid item xs={3}>
        <Card sx={{ minWidth: 350 }}>
        <Stack direction='row'>
            <CardMedia
            component="img"
            image="/images/pngwing.com.png"
            alt="green iguana"
            sx={{ width: '20%', height: '150px',margin: 'auto',marginTop:'20px', padding:'10px' }}
            />
            <CardContent>
            <CardActions sx={{justifyContent: 'flex-end', textAlign: 'right', marginTop:'-10px'}}>
                <Button variant="contained" onClick={handleDelete} sx={{backgroundColor:'#993f54'}}>
                <DeleteIcon />
                </Button>
                <Button variant="contained" onClick={handleDelete} sx={{backgroundColor:'#1D1A39'}}>
                <BorderColorIcon />
                </Button>
            </CardActions>
            <Typography gutterBottom variant="h5" component="div" sx={{fontSize:'15px'}}>
                Robe de soiree
            </Typography>
            <Typography gutterBottom variant="p" component="div" sx={{fontSize:'12px'}}>
                Stock: 100
            </Typography>
            <Typography variant="subtitle2" gutterBottom>
        Description:
      </Typography>
      <Typography variant="body1" gutterBottom>
        body1. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos
        blanditiis tenetur unde suscipit, quam beatae rerum inventore consectetur,
        neque doloribus, cupiditate numquam dignissimos laborum fugiat deleniti? Eum
        quasi quidem quibusdam.
      </Typography>
            </CardContent>
        </Stack>
       
    </Card>
    <SuppForm open={open} onClose={handleClose} />
  </Grid>
    );
};
export default FrCardVert;