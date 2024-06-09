import React,{useState} from 'react';
import { Button, Container, Paper, TextField, Typography,Box } from '@mui/material';
import axios from 'axios'; 
import { useNavigate } from 'react-router-dom';
import IconButton from '@mui/material/IconButton';
import Input from '@mui/material/Input';
import { outlinedInputClasses } from '@mui/material/OutlinedInput';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import { createTheme, ThemeProvider, useTheme } from '@mui/material/styles';

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
            '--TextField-brandBorderColor': 'linear-gradient(90deg, #FF8E53, #FE6B8B)',
            '--TextField-brandBorderHoverColor': '#B2BAC2',
            '--TextField-brandBorderFocusedColor': '#FFAD64',
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
 
const SignUp = () =>{
    const outerTheme = useTheme();
    //recup data
    const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmpassword, setConfirmPassword] = useState('');
  const [company, setCompany] = useState(''); 
  const [contactFr, setContactFr] = useState(''); 
  const [adresseFr, setAdresseFr] = useState(''); 
  const [error, setError] = useState(''); 
  const history = useNavigate(); 
   // afficher et cacher le mot de passe
   const [showPassword, setShowPassword] = React.useState(false);

   const handleClickShowPassword = () => setShowPassword((show) => !show);
 
   const handleMouseDownPassword = (event) => {
     event.preventDefault();
   };

  const handleSignup = async (event) => { 
    event.preventDefault();
    try { 
        // Check for empty fields 
        if (!company || !email || !password || !confirmpassword || !contactFr || !adresseFr) { 
            setError('Veuillez remplir tous les champs'); 
            return; 
        } 

        if (password !== confirmpassword) { 
            throw new Error("Les mots de passes ne se correspondent pas"); 
        } 
        // OTRAN'ITO NY CALL fa soloina http://localhost:8092/auth/client/signup 
        const response = await axios.post('http://localhost:8092/auth/fournisseur/signup', {
          company,
          mailFr: email,
          mdpFr: password,
          contactFr,
          adresseFr
      }); /*, {
        withCredentials: true // Include cookies in the request
    }*/ 
        //  success signup 
        console.log(response.data); 
        history('/dashboard-fournisseur'); 
    } catch (error) { 
        //  signup error 
        console.error('Signup echec:', error.response ? error.response.data : error.message); 
        setError(error.response ? error.response.data : error.message); 
    } 
}; 
    return (
        <Container maxWidth="sm" style={{ display: 'flex', justifyContent: 'center', alignItems: 'center',minHeight:'100vh' }}>
        <Paper elevation={3} sx={{ padding: '20px' }}>
        <Box style={{ display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
  <img src="/logo.png" alt="Tsena" width="80px" />
  <img src="/logotsena.png" alt="Tsena" width="80px" />
  </Box>
          
          <form >
          <ThemeProvider theme={customTheme(outerTheme)}>
          <TextField
              label="Nom de votre companie"
              type="text"
              fullWidth
              required
              margin="normal"
              variant="outlined"
              value={company}
              onChange={(e) => setCompany(e.target.value)}
                
            />
            <TextField
              label="Email"
              type="email"
              fullWidth
              required
              margin="normal"
              variant="outlined"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              
            />
            <TextField
              label="Contact mobile"
              type="text"
              fullWidth
              margin="normal"
              variant="outlined"
              value={contactFr}
              onChange={(e) => setContactFr(e.target.value)}
              
            />
             <TextField
              label="Adresse"
              type="text"
              fullWidth
              margin="normal"
              variant="outlined"
              value={adresseFr}
              onChange={(e) => setAdresseFr(e.target.value)}
              
            />
            <FormControl sx={{mt: 2, width: '100%' }} variant="outlined">
              <InputLabel htmlFor="outlined-adornment-password">Mot de passe</InputLabel>
              <OutlinedInput
                sx={{borderColor:'orange'}}
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
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                
              />
            </FormControl>
    
            <TextField
              label="Confirmer mot de passe"
              type="password"
              fullWidth
              margin="normal"
              variant="outlined"
              value={confirmpassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
              
            />
            </ThemeProvider>
            <Typography variant="p" gutterBottom>
           En creer votre compte , vous acceptez de suivre nos conditions d'utilisations
          </Typography>
              {error && <p className="text-danger">{error}</p>}
            <Button type="submit" variant="contained" fullWidth
             sx={{ marginTop: '20px',
                   background: 'linear-gradient(90deg, rgba(255,109,109,0.8688725490196079) 0%, rgba(255,184,27,1) 100%)', //linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)
                    borderRadius: 3,
                    border: 0,
                    color: 'white',
                    height: 48,
                    padding: '0 30px',
                    boxShadow: '0 3px 5px 2px rgba(255, 105, 135, .3)', }} onClick={handleSignup}>
              Creer votre compte fournisseur
            </Button>
            <Container> 
                          <p>Vous avez deja un compte? <a href="/login-fournisseur" >Connectez-vous</a> !</p> 
                      </Container> 
          </form>
        </Paper>
      </Container>
    );
};
export default SignUp;