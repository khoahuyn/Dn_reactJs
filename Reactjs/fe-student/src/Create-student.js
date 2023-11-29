import React from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import './create-student.css';
import anh from './image/default-avatar.png';
import * as Yup from "yup";

export function Create() {

    function displayImage(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                document.getElementById('avatar-image').src = e.target.result;
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    return (
        <>
            <Formik
                initialValues=
                    {{
                        studentId: '',
                        name: '',
                        dateOfBirth: '',
                        address: '',
                        phone: '',
                        email: '',
                        avatar: '',
                        gender: '',
                        deleteFlag: '',
                        grade: '',
                        account: ''
                    }}
                onSubmit={() => {

                }}


                validationSchema={Yup.object({
                    name: Yup.string()
                        .required('Tên sinh viên không được để trống')
                        .min(5, 'Tên sinh viên không được bé hơn 5')
                        .max(50, 'Tên sinh viên không được lớn hơn 50')
                        .matches(/^[a-zA-Z\s]+$/, "Tên sinh viên không được chứa ký tự đặc biệt"),
                    email: Yup.string()
                        .required('Email không được để trống')
                        .max(50, "Email không được lớn hơn 50")
                        .matches(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/, 'Email không hợp lệ'),
                    phone: Yup.string()
                        .required('Số điện thoại không được để trống')
                        .min(10, "Số điện thoại phải tối thiểu 10 chữ số")
                        .matches(/^[0-9]+$/, 'Số điện thoại không hợp lệ'),
                    dateOfBirth: Yup.string()
                        .required("Ngày tháng năm không được để trống")
                        .matches(/^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/\d{4}$/, "Ngày tháng năm  không hợp lệ"),
                    address: Yup.string()
                        .required("Địa chỉ không được để trống")
                        .min(5, 'Địa chỉ không được bé hơn 5')
                        .max(50, 'Địa chỉ viên không được lớn hơn 50'),
                    avatar: Yup.mixed()
                        // .test("Ảnh quá lớn", (value) => value && value.size < 1024 * 1024)
                        // .test("File không hợp lệ",
                        //     (value) => value && ['avatar/png', 'avatar/jpeg', 'avatar/jpg'].includes(value.type))


                })}
            >
                <Form>
                    <div className="container">

                        <div className="header">
                            <h2 className="title">THÊM MỚI SINH VIÊN</h2>
                        </div>

                        <form>
                            <div className="row">
                                <div className="col-md-3 mr-2">
                                    <div className="avatar-container">
                                        <img src={anh} alt="Avatar" className="avatar"
                                             id="avatar-image"/>
                                        <div className="form-group mt-2" style={{textAlign: "center"}}>
                                            <label>Chọn ảnh đại diện</label>
                                            <input type="file" accept=".png, .jpg, .jpeg, .webp"
                                                   className="form-control form-control-file inputfile btn btn-primary"
                                                   id="avatar" onChange={(e) => displayImage(e.target)}/>
                                            <br/>
                                            <label htmlFor="avatar">Chọn tệp</label>
                                            <ErrorMessage name="avatar" className="text-danger" component="p"/>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-4 mr-5">
                                    <div className="form-group">
                                        <label htmlFor="name">Tên sinh viên (<span
                                            className="text-danger">*</span>):</label>
                                        <Field type="text" className="form-control" id="name" name="name"/>
                                        <ErrorMessage name="name" className="text-danger" component="p"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="dateOfBirth">Ngày Sinh (<span className="text-danger">*</span>):</label>
                                        <Field type="date" className="form-control" id="dateOfBirth"
                                               name="dateOfBirth"/>
                                        <ErrorMessage name="dateOfBirth" className="text-danger" component="p"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="grade">Lớp (<span className="text-danger">*</span>):</label>
                                        <Field as="select" className="form-control" id="grade" name="grade">
                                            <option>A0322I1</option>
                                            <option>A0522I1</option>
                                            <option>A0722I1</option>
                                            <option>A0922I1</option>
                                            <option>A1122I1</option>
                                        </Field>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="email">Email (<span className="text-danger">*</span>):</label>
                                        <Field type="text" className="form-control" id="email" name="email"/>
                                        <ErrorMessage name="email" className="text-danger" component="p"/>
                                    </div>
                                </div>
                                <div className="col-md-4">
                                    <div className="form-group">
                                        <label htmlFor="phone">Số Điện Thoại (<span
                                            className="text-danger">*</span>):</label>
                                        <Field type="text" className="form-control" id="phone" name="phone"/>
                                        <ErrorMessage name="phone" className="text-danger" component="p"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="address">Địa Chỉ (<span
                                            className="text-danger">*</span>):</label>
                                        <Field as="textarea" className="form-control" id="address" name="address"/>
                                        <ErrorMessage name="address" className="text-danger" component="p"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="gender">Giới Tính (<span
                                            className="text-danger">*</span>):</label>
                                        <Field as="select" className="form-control" id="gender" name="gender">
                                            <option>Nam</option>
                                            <option>Nữ</option>
                                        </Field>
                                    </div>
                                    <div className="mt-3 save-exit-buttons">
                                        <button className="btn btn-outline-success">Lưu</button>
                                        <button className="btn btn-outline-secondary ml-2">Thoát</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </Form>
            </Formik>
        </>
    );
}