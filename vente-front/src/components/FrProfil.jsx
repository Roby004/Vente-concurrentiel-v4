import React,{useState,useEffect} from 'react';
import { Box, Button, Container, Paper, TextField, Typography,Grid, Avatar,Stack} from '@mui/material';
import axios from 'axios'; 
import SuppFrForm from '../components/SuppFrForm.jsx';
import { useNavigate } from 'react-router-dom';
import IconButton from '@mui/material/IconButton';
import EditIcon from '@mui/icons-material/Edit';
import Input from '@mui/material/Input';
import { outlinedInputClasses } from '@mui/material/OutlinedInput';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import { alpha, styled } from '@mui/material/styles';
import { createTheme, ThemeProvider, useTheme } from '@mui/material/styles';


//Styler les inputs
const styleinput = styled(TextField)({
  '& label.Mui-focused': {
    color: '#FF8E53',
  },
  '& .MuiInput-underline:after': {
    borderBottomColor: '#FF8E53',
  },
  '& .MuiOutlinedInput-root': {
    '& fieldset': {
      borderColor: '#FF8E53',
    },
    '&:hover fieldset': {
      borderColor: '#B2BAC2',
    },
    '&.Mui-focused fieldset': {
      borderColor: '#FF8E53',
    },
  },
});
//Styler les inputs
const customTheme = (outerTheme) =>
  createTheme({
    palette: {
      mode: outerTheme.palette.mode,
    },
    components: {
      MuiTextField: {
        styleOverrides: {
          root: {
            '--TextField-brandBorderColor': '#B2BAC2',
            '--TextField-brandBorderHoverColor':'#FF8E53' ,
            '--TextField-brandBorderFocusedColor': '#FF8E53',
            '& label.Mui-focused': {
              color: 'var(--TextField-brandBorderFocusedColor)',
            },
          },
        },
      },
      MuiOutlinedInput: {
        styleOverrides: {
          notchedOutline: {
            borderColor: 'var(--TextField-brandBorderColor)',
          },
          root: {
            [ `&:hover .${outlinedInputClasses.notchedOutline}`]: {
              borderColor: 'var(--TextField-brandBorderHoverColor)',
            },
            [`&.Mui-focused .${outlinedInputClasses.notchedOutline}`]: {
              borderColor: 'var(--TextField-brandBorderFocusedColor)',
            },
          },
        },
      },
      MuiInput: {
        styleOverrides: {
          root: {
            '&::before': {
              borderBottom: '2px solid var(--TextField-brandBorderColor)',
            },
            '&:hover:not(.Mui-disabled, .Mui-error):before': {
              borderBottom: '2px solid var(--TextField-brandBorderHoverColor)',
            },
            '&.Mui-focused:after': {
              borderBottom: '2px solid var(--TextField-brandBorderFocusedColor)',
            },
          },
        },
      },
      
    },
  });

const FrProfil = () => {
  const outerTheme = useTheme();
  const [frDetail, setFrDetail] = useState({
    company: '',
    mailFr: '',
    mdpFr: '',
    contactFr: '',
    adresseFr: '',
  });
  const [showPassword, setShowPassword] = useState(false);
  const [mailFr, setMailFr] = useState(frDetail.mailFr);
  const [mdpFr, setMdpFr] = useState(frDetail.mdpFr);
  const [confirmpassword, setConfirmPassword] = useState('');
  const [company, setCompany] = useState(frDetail.company);
  const [contactFr, setContactFr] = useState(frDetail.contactFr);
  const [adresseFr, setAdresseFr] = useState(frDetail.adresseFr);
  const [error, setError] = useState('');
  const [profil, setProfil] = useState('/defautPic.png');
  const [imgFr, setImgFr] = React.useState(null);
  const [openDel, setOpenDel] = useState(false);
  const fournisseurId = localStorage.getItem('fournisseurId');

 
  const handleDelete = () => {
    setOpenDel(true); // Open the modal on button click
  };
  const handleClose = () => {
    setOpenDel(false); 
   // Close the modal
  };

  const handleClickShowPassword = () => setShowPassword((show) => !show);

  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };
  const handleFileImg = (event) => {
    const file = event.target.files[0];
    const reader = new FileReader();
    reader.onload = () => {
      // Set the uploaded image as the profile picture
      setImgFr(reader.result);
      setProfil(reader.result);
    };
    reader.readAsDataURL(file);
  };

  React.useEffect(() => {
    const fetchFrDetails = async () => {
      //const fournisseurId = localStorage.getItem('fournisseurId');
    if (fournisseurId) {
      try {
        const response = await axios.get(`http://localhost:8092/auth/detailFr/${fournisseurId}`);
        setFrDetail(response.data); 
        console.log("recuperation réussie",frDetail);
        setMailFr(frDetail.mailFr);
        setContactFr(frDetail.contactFr);
        setAdresseFr(frDetail.adresseFr);
        setCompany(frDetail.company);
        setMdpFr(frDetail.mdpFr);
        if (frDetail.imgFr) {
          //setImgFr(`data:image/jpeg;base64,${frDetail.imgFr}`);
          setProfil(`data:image/jpeg;base64,${frDetail.imgFr}`);
      }

      } catch (error) {
        console.error('Impossible de recuperer les data:', error);
      }
    }
    };
  
    fetchFrDetails();
  }, [fournisseurId]);

  const handleModifier = async (event) => {
    event.preventDefault();
    try {
      // check champs vides
      if (!company || !mailFr || !mdpFr || !contactFr || !adresseFr) {
        setError('Veuillez remplir tous les champs');
        return;
      }
  
      // Check mdp
      if (mdpFr !== confirmpassword) {
        setError("Les mots de passe ne correspondent pas");
        return;
      }
  
      if(fournisseurId){
      const response = await axios.put(`http://localhost:8092/auth/fournisseurPut/${fournisseurId}`, {
        company,
        mailFr,
        mdpFr,
        contactFr,
        adresseFr
      });
    }
      // Success 
      console.log(response.data);
      history.push('/dashboard-fournisseur');
    } catch (error) {
      //Erreur
      console.error('Error updating profile:', error.response ? error.response.data : error.message);
      setError(error.response ? error.response.data : error.message);
    }

    if (imgFr) {
      const formData = new FormData();
      formData.append('imgFile', imgFr);
  
      try {
        const response = await axios.put(`http://localhost:8092/auth/fournisseurPutImg/${fournisseurId}`, formData, {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        });
        console.log('Product image updated successfully:', response.data);
      } catch (error) {
        console.error('Error updating product image:', error);
      }
    }
  };
  
  
  return (
    <Container maxWidth="md" style={{ display: 'flex', backgroundColor: 'white',marginTop:'100px', marginBottom:'50px' }}>
      <Box height={'inherit'} sx={{margin:'10px 100px 10px 10px',maxWidth:'35%',display: 'flex', justifyContent: 'center',padding:'10px'}} >
      <label htmlFor="profile-picture-input">
          <Avatar alt="Profile Picture" src={profil} sx={{ width: 150, height: 150, margin: '20px',marginTop:'150px' }} />
          <input
            id="profile-picture-input"
            type="file"
            accept="image/*"
            style={{ display: 'none' }}
            onChange={handleFileImg}
          />
          <IconButton aria-label="edit profile picture" component="span" sx={{alignSelf:'self-end', marginLeft:'150px', marginTop:"-90px"}}>
            <EditIcon />
          </IconButton>
        </label>
      </Box>
      <Paper elevation={0} maxWidth="sm" sx={{ padding: '20px' }}>
        <Typography variant="h5" gutterBottom sx={{ textAlign: 'center', color: 'orange' }}>
          Vos informations
        </Typography>
        <form>
        <ThemeProvider theme={customTheme(outerTheme)}>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <TextField
                  label="Nom de votre compagnie"
                  type="text"
                  fullWidth
                  required
                  margin="normal"
                  variant="outlined"
                  value={company}
                  onChange={(e) => setCompany(e.target.value)}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  label="Email"
                  type="email"
                  fullWidth
                  required
                  margin="normal"
                  variant="outlined"
                  value={mailFr}
                  onChange={(e) => setMailFr(e.target.value)}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  label="Contact mobile"
                  type="text"
                  fullWidth
                  margin="normal"
                  variant="outlined"
                  value={contactFr}
                  onChange={(e) => setContactFr(e.target.value)}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  label="Adresse"
                  type="text"
                  fullWidth
                  margin="normal"
                  variant="outlined"
                  value={adresseFr}
                  onChange={(e) => setAdresseFr(e.target.value)}
                />
              </Grid>
              <Grid item xs={12} id="inputMdp">
                <FormControl sx={{ mt: 2, width: '100%' }} variant="outlined">
                  <InputLabel htmlFor="outlined-adornment-password">Mot de passe</InputLabel>
                  <OutlinedInput  
                  
                    id="outlined-adornment-password"
                    type={showPassword ? 'text' : 'password'}
                    
                    
                    endAdornment={
                      <InputAdornment position="end">
                        <IconButton
                          aria-label="toggle password visibility"
                          onClick={handleClickShowPassword}
                          onMouseDown={handleMouseDownPassword}
                          edge="end"
                        >
                          {showPassword ? <VisibilityOff /> : <Visibility />}
                        </IconButton>
                      </InputAdornment>
                    }
                    label="mot de passe"
                    value={mdpFr}
                    onChange={(e) => setMdpFr(e.target.value)}
                  />
                </FormControl>
              </Grid>
              {mdpFr && (
                <Grid item xs={12}>
                  <TextField
                    label="Confirmer mot de passe"
                    type="password"
                    fullWidth
                    margin="normal"
                    variant="outlined"
                    value={confirmpassword}
                    onChange={(e) => setConfirmPassword(e.target.value)}
                  />
                </Grid>
              )}
            </Grid>
          </ThemeProvider>
          <Typography variant="p" gutterBottom>
            En cliquant sur "modifier" vous pourrez mettre à jour vos informations personnelles
          </Typography>
          {error && <p className="text-danger">{error}</p>}
                <Stack direction={'column'}>
          <Button
            type="submit"
            variant="outlined"
            fullWidth
            sx={{
              marginTop: '20px',
        borderRadius: 2,
        height: 48,
              padding: '0 30px',
        border: '3px solid transparent',
        backgroundImage: 'linear-gradient(#fff, #fff), linear-gradient(90deg, rgba(255,109,109,0.8688725490196079) 0%, rgba(255,184,27,1) 100%)',
        backgroundOrigin: 'padding-box, border-box',
        backgroundClip: 'padding-box, border-box',
    
    transition: 'all 0.3s ease-in-out',
        '&:hover': {
          backgroundImage: 'linear-gradient(#fff, #fff), linear-gradient(90deg, rgba(255,109,109,0.8688725490196079) 0%, rgba(255,184,27,1) 100%)',
          borderColor: 'rgba(255,184,27,1)',
          boxShadow: 'none',
        },
            }}
            onClick={handleModifier}
          >
            <Typography
             sx={{
              background: 'linear-gradient(60deg, rgba(255,109,109,0.8688725490196079) 0%, rgba(255,184,27,1) 100%)',
              backgroundClip: 'text',
              color: 'transparent',
            fontWeight:'500'}} 
            component={'p'}>Valider les modifications</Typography>
          </Button>
          <Button
            type="button"
            variant="contained"
            fullWidth
            sx={{
              marginTop: '20px',
              background: 'linear-gradient(90deg, rgba(255,109,109,0.8688725490196079) 0%, rgba(255,15,27,0.8) 60%)',
              borderRadius: 2,
              border: 0,
              color: 'white',
              height: 48,
              padding: '0 30px',
              boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)',
            }}
            onClick={handleDelete}
          >
            Supprimer votre compte
          </Button>
          </Stack>
        </form>
      </Paper>
      <SuppFrForm open={openDel} onClose={handleClose} />
    </Container>
    
  );
};

export default FrProfil;
